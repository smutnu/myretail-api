/**
 * 
 */
package com.myretail.product.api;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.myretail.exception.ProductException;
import com.myretail.product.model.Product;
import com.myretail.product.model.ProductRepository;

/**
 * @author Satya
 * 
 * RestAPI defined for services associated to my-retail. Supports retrieval of production information and updating pricing information of a product.
 *
 */
//TODO add olingo Odata support to support Odata api for our rest services.
//TODO add webflux and reactive spring support for enhanced reactive framework support
@RestController
@RequestMapping(value="/my-retail")
public class MyRetailProductController {
	
	@Autowired
	MyRetailProductOrchestrator orchestrator;
	
	@Autowired
	ProductRepository priceRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(MyRetailProductController.class);
	
	/**
	 * @param id
	 * @return
	 * 
	 * Retrieves the requested product information from redsky product service and current price from nosql database when exists.
	 */
	@GetMapping(value="/products/{id:[0-9]+}")
	@ResponseBody
	Product findProductById(@PathVariable Integer id) {
		Product product = new Product();
		product.setId(id);
		//TODO - add futures for asynchronous processing and metrics to capture performance statistics.
		try {
			product.setName(orchestrator.getProductName(id));
		}catch(HttpClientErrorException exp) {
			logger.error(exp.getMessage());
		}
		Optional<Product> productObj = priceRepository.findById(product.getId());
		if(productObj.isPresent()) {
			product.setCurrentPrice(productObj.get().getCurrentPrice());
		}
		
		return product;
	}
	
	/**
	 * @param id
	 * @param product
	 * @return
	 * 
	 * Add/Update the pricing information associated to a product in nosql database
	 * 
	 */
	@PutMapping(value="products/{id}/price")
	@ResponseBody
	//@PreAuthorize("hasRole('ADMIN')") //TODO - Add security 
	Product savePriceById(@PathVariable Integer id, @RequestBody Product product) throws ProductException {
		if(product.getId()!= null && !id.equals(product.getId())) {
			throw new ProductException("invalid request");
		}
		product.setId(id);
		priceRepository.save(product);
		return product;
		
	}
	
	


}

package com.myretail.product.api;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.myretail.config.MyRetailConfiguration;
import com.redsky.product.model.ProductDescription;
import com.redsky.product.model.RedskyProductServiceResponse;

@Component
@ConfigurationProperties(prefix="redsky")
public class MyRetailProductOrchestrator {
	
	@Autowired
	MyRetailConfiguration configuration;
	
	private static final Logger logger = LoggerFactory.getLogger(MyRetailProductOrchestrator.class);

	/**
	 * @param idVal
	 * Initiate service call to redsky product service to fetch the name.
	 * @return
	 */
	public String getProductName(Integer idVal) {
		Map<String,Integer> params = new HashMap<>();
		params.put("id", idVal);
		logger.info("initiating redSky Service call for {}",idVal);
		RedskyProductServiceResponse redSkyProductServiceResponse= new RestTemplate().getForObject(
				configuration.getNameServiceUrl(),RedskyProductServiceResponse.class,params);
		
		return redSkyProductServiceResponse.getProduct().getItem().getProduct_description().flatMap(ProductDescription::getTitle).orElse("Not Available");
	}
}

package com.myretail.product.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Satya
 *
 * Price Repository is the Spring Data repository which has the complete set of persistence methods through CrudRepository interface
 */
@Repository
public interface ProductRepository extends CrudRepository<Product,Integer>{
	
}

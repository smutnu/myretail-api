package com.myretail.product.model;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * @author Satya
 * Product is the Entity in redis repository
 */
@RedisHash("Product")
public class Product implements Serializable{
	
	
	/**
	 * To guarantee a consistent serialVersionUID value across different Java compiler implementations, 
	 * a serializable class must declare an explicit serialVersionUID value. 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id private Integer id;
	
	@Valid
	@Pattern(regexp="^$|[a-z][A-Z][0-9]( ,.')*$")
	private String name;
	
	@Valid
	private Price currentPrice;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Price getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Price currentPrice) {
		this.currentPrice = currentPrice;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", currentPrice=" + currentPrice + "]";
	}
	
	
}

package com.redsky.product.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Item {
	private Optional<ProductDescription> product_description;

	public Optional<ProductDescription> getProduct_description() {
		return product_description;
	}

	public void setProduct_description(Optional<ProductDescription> product_description) {
		this.product_description = product_description;
	}

	@Override
	public String toString() {
		return "Item [product_description=" + product_description + "]";
	}
	
	
}

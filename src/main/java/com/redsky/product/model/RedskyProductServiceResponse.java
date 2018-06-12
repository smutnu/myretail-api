package com.redsky.product.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class RedskyProductServiceResponse {
	private RedskyProduct product;

	public RedskyProduct getProduct() {
		return product;
	}

	public void setProduct(RedskyProduct product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "RedskyProductServiceResponse [product=" + product + "]";
	}
	
}

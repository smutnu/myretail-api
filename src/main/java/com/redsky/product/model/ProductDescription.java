package com.redsky.product.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ProductDescription {
	private Optional<String> title;

	public Optional<String> getTitle() {
		return title;
	}

	public void setTitle(Optional<String> title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "ProductDescription [title=" + title + "]";
	}
	
}

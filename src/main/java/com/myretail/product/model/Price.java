package com.myretail.product.model;

import java.io.Serializable;

/**
 * @author Satya
 *
 */

public class Price implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public enum CurrencyCode{
		USD,INR
	}
		
	private Double value;
	private CurrencyCode currencyCode;
	
	public double getValue() {
		return value;
	}
	public Price() {
		super();
	}
	public void setValue(double value) {
		this.value = value;
	}
	public CurrencyCode getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(CurrencyCode currencyCode) {
		this.currencyCode = currencyCode;
	}
	public Price(double value, CurrencyCode currencyCode) {
		super();
		this.value = value;
		this.currencyCode = currencyCode;
	}
	
	
	
	
}

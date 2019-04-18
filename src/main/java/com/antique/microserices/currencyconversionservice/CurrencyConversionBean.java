package com.antique.microserices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversionBean {
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiplte;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	private int port;
	
	public CurrencyConversionBean() {
		// TODO Auto-generated constructor stub
	}
	public CurrencyConversionBean(String from, String to, BigDecimal conversionMultiplte) {
		super();
		this.from = from;
		this.to = to;
		this.conversionMultiplte = conversionMultiplte;
	}
	
	
	public CurrencyConversionBean(Long id, String from, String to, BigDecimal conversionMultiplte, BigDecimal quantity,
			BigDecimal totalCalculatedAmount) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiplte = conversionMultiplte;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiplte() {
		return conversionMultiplte;
	}
	public void setConversionMultiplte(BigDecimal conversionMultiplte) {
		this.conversionMultiplte = conversionMultiplte;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	
}

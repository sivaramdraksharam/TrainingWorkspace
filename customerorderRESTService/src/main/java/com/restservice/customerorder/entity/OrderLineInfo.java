package com.restservice.customerorder.entity;

import java.math.BigDecimal;

public class OrderLineInfo {
	private String prdId;
	private int quantity;
	private BigDecimal unitSalePrice;
	
	public String getPrdId() {
		return prdId;
	}
	public void setPrdId(String prdId) {
		this.prdId = prdId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getUnitSalePrice() {
		return unitSalePrice;
	}
	public void setUnitSalePrice(BigDecimal unitSalePrice) {
		this.unitSalePrice = unitSalePrice;
	}
}

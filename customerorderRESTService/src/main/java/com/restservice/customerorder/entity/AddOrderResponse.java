package com.restservice.customerorder.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AddOrderResponse {
	private int orderId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}

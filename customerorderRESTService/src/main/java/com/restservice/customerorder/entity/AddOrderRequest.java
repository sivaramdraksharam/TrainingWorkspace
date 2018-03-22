package com.restservice.customerorder.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AddOrderRequest {
	private int customerId;
	private List<OrderLineInfo> orderlineInfo;

	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public List<OrderLineInfo> getOrderlineInfo() {
		return orderlineInfo;
	}
	public void setOrderlineInfo(List<OrderLineInfo> orderlineInfo) {
		this.orderlineInfo = orderlineInfo;
	}
	
}

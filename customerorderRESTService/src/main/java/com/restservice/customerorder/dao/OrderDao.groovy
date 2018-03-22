package com.restservice.customerorder.dao

import com.restservice.customerorder.entity.EOrder
import com.restservice.customerorder.entity.EProduct

interface OrderDao {
	

	int addOrder(EOrder order);	
	EProduct getProduct(String prdId);	
	List<EOrder> getOrders(Integer customerId)
	List<EOrder> getAllOrders()
	boolean deleteOrder(int orderId)
	boolean deleteOrderLine(int orderId,String productId);
}

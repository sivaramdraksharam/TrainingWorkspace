package com.vjay.cxfservice.dao

import com.vjay.cxfservice.entity.EOrder
import com.vjay.cxfservice.entity.EProduct
import com.vjay.cxfservice.entity.TestTable

interface OrderDao {
	
	List<TestTable> getOrder(BigInteger orderId)
	int addOrder(EOrder order);	
	EOrder getOrderById(Integer id);
	EProduct getProduct(String prdId);	
	List<EOrder> getOrders(Integer customerId)
	boolean deleteOrder(int orderId)
	boolean deleteOrderLine(int orderId,String productId);
}

package com.restservice.customerorder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restservice.customerorder.dao.OrderDao;
import com.restservice.customerorder.entity.AddOrderRequest;
import com.restservice.customerorder.entity.AddOrderResponse;
import com.restservice.customerorder.entity.DeleteOrderLineRequest;
import com.restservice.customerorder.entity.DeleteOrderLineResponse;
import com.restservice.customerorder.entity.DeleteOrderResponse;
import com.restservice.customerorder.entity.EOrder;
import com.restservice.customerorder.entity.EOrderLine
import com.restservice.customerorder.entity.EProduct
import com.restservice.customerorder.exception.OrderServiceException

@Service("customerOrderImpl") 
public class CustomerOrderServiceImpl implements CustomerOrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public List<EOrder> getCustomerOrders(int customerId) throws OrderServiceException{
		List<EOrder> orders = new ArrayList<>();
		orders = orderDao.getOrders(customerId);
		if(orders.size()==0)
			throw new OrderServiceException("No orders found for given customer id")
		return orders;
	}

	@Override
	public  AddOrderResponse addOrder(AddOrderRequest request) {
		EOrder order = new EOrder();
		order.customerId = request.customerId
		request.orderlineInfo.each{
			EProduct prd = orderDao.getProduct(it.prdId)
			order.eorderLines << new EOrderLine(quantity: it.quantity, unitSaleprice: it.unitSalePrice,product: prd)
		}
		int resultid = orderDao.addOrder(order);
		AddOrderResponse response = new AddOrderResponse();
		response.orderId = resultid 
		return response; 
	}

	@Override
	public Map<String,Object> deleteOrderLine(DeleteOrderLineRequest request) {
		
		boolean result = orderDao.deleteOrderLine(request.orderId, request.productId)
		def response = [
				"result":result
			]
		return response;
	}

	@Override
	public Map<String,Object> deleteOrder(int orderId) {
		boolean result = orderDao.deleteOrder(orderId);
		def response = [
			"result":result
		]
		return response;
	}

}

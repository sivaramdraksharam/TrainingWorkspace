package com.vjay.cxfservice.endpointimpl

import javax.jws.HandlerChain

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import com.vjay.customerorder.order.AddOrderRequest
import com.vjay.customerorder.order.AddOrderResponse
import com.vjay.customerorder.order.DeleteOrderLineRequest
import com.vjay.customerorder.order.DeleteOrderLineResponse
import com.vjay.customerorder.order.DeleteOrderRequest
import com.vjay.customerorder.order.DeleteOrderResponse
import com.vjay.customerorder.order.GetCustomerOrderRequest
import com.vjay.customerorder.order.GetCustomerOrderResponse
import com.vjay.customerorder.order.GetOrderRequest
import com.vjay.customerorder.order.GetOrderResponse
import com.vjay.customerorder.order.Order
import com.vjay.customerorder.order.OrderDetails
import com.vjay.customerorder.order.OrderLine
import com.vjay.cxfservice.constant.Unit
import com.vjay.cxfservice.customerorderservice.CustomerOrderService
import com.vjay.cxfservice.dao.OrderDao
import com.vjay.cxfservice.entity.EOrder
import com.vjay.cxfservice.entity.EOrderLine
import com.vjay.cxfservice.entity.EProduct

@Component
@HandlerChain(file="handler-chain.xml")
class CustomerOrderServiceImpl implements CustomerOrderService {
	
	@Autowired
	OrderDao orderDao;
	
	@Override
	public GetOrderResponse getOrder(GetOrderRequest orderrequest) {  
		def id =orderrequest.orderId
		def order = orderDao.getOrderById(id)  
		
		GetOrderResponse response = new GetOrderResponse();
		Order orderResp = new Order();
		orderResp.customerId = order.customerId
		orderResp.orderId = order.orderId
		order.eorderLines.each{
			orderResp.orderLines << new OrderLine(lineId: it.lineId,prdId: it.product.prdId,quantity: it.quantity,unitSaleprice: it.unitSaleprice)    			
		}
		response.setOrder(orderResp); 
		println orderResp.customerId 
		println response.getOrder().customerId	  	  
		return response;          
	}

	@Override
	public AddOrderResponse addOrder(AddOrderRequest order) {
		OrderDetails orderDetail =  order.getOrderDetail()
		EOrder orderObj = new EOrder();
		
		/*Iterating the line item details to create line item*/
		orderDetail.orderlineInfo.each{
			def prd = orderDao.getProduct(it.prdId)
			orderObj.eorderLines << new EOrderLine(quantity: it.quantity,unitSaleprice: it.unitSalePrice,product: prd)   	
		}
		
		
		orderObj.customerId= orderDetail.customerId
		int genid = orderDao.addOrder(orderObj);
			
		AddOrderResponse response = new AddOrderResponse()
		response.setOrderId(genid)
		return response;  
	}

	@Override
	public GetCustomerOrderResponse getCustomerOrder(GetCustomerOrderRequest request) {
		def custid =request.customerId
		List<EOrder> eorders = orderDao.getOrders(custid) 
		
		GetCustomerOrderResponse response = new GetCustomerOrderResponse()
		eorders.each{order ->
			Order orderResp = new Order();
			orderResp.customerId = order.customerId
			orderResp.orderId = order.orderId
			
			order.eorderLines.each{  
				orderResp.orderLines << new OrderLine(lineId: it.lineId,prdId: it.product.prdId,quantity: it.quantity,unitSaleprice: it.unitSaleprice)
			}
			response.orders << orderResp
		}
		return response;
	}

	@Override
	public DeleteOrderLineResponse deleteOrderLine(DeleteOrderLineRequest request) {
		int orderId = request.orderId
		String productId = request.productId
		boolean status = orderDao.deleteOrderLine(orderId, productId);
		DeleteOrderLineResponse response = new DeleteOrderLineResponse()
		response.status = status
		return response;
	}

	@Override
	public DeleteOrderResponse deleteOrder(DeleteOrderRequest request) {
		int orderId = request.orderId
		boolean status = orderDao.deleteOrder(orderId);
		DeleteOrderResponse response = new DeleteOrderResponse()
		response.status = status
		return response;
	}

	
}

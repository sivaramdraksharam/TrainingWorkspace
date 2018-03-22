package com.restservice.customerorder;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.restservice.customerorder.entity.AddOrderRequest;
import com.restservice.customerorder.entity.AddOrderResponse;
import com.restservice.customerorder.entity.DeleteOrderLineRequest;
import com.restservice.customerorder.entity.EOrder;
import com.restservice.customerorder.exception.OrderServiceException;

@Path("/")
public interface CustomerOrderService {
	
	@Path("getOrder/{customerId}")
	@GET
	@Produces("application/json")
	public List<EOrder> getCustomerOrders(@PathParam("customerId")int customerId) throws OrderServiceException;
	
	@Path("addOrder")
	@POST
	@Produces("application/json")
	public  AddOrderResponse addOrder(AddOrderRequest response);
	
	@Path("deleteOrderline")
	@POST
	@Produces("application/json")
	public Map<String,Object> deleteOrderLine(DeleteOrderLineRequest request);
	
	@Path("deleteOrder/{orderId}")
	@GET
	@Produces("application/json")
	public Map<String,Object> deleteOrder(@PathParam("orderId")int orderId);
	
	
}

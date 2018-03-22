package com.restservice.customerorder.handler

import com.restservice.customerorder.exception.OrderServiceException

import javax.ws.rs.client.Entity
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper

class CSOResponseHandler implements ExceptionMapper<OrderServiceException>{

	@Override
	public Response toResponse(OrderServiceException exception) {
		Response.Status status = Response.Status.INTERNAL_SERVER_ERROR; 
		Map<String,Object> entity= new HashMap();
		//Entity ent = 1000;
		
		entity.put("responseMessage",  exception.getMessage())
		entity.put("responseCode", 500);
		return Response.ok(entity).status(status).header("exception", exception.getMessage()).build();;
	}

}

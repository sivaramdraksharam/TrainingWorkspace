package com.restservice.customerorder.handler;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.codehaus.jackson.map.JsonMappingException;

public class CSORequestExpHandler implements ExceptionMapper<JsonMappingException>{

	@Override
	public Response toResponse(JsonMappingException exception) {
		Response.Status status = Response.Status.INTERNAL_SERVER_ERROR; 
		Map<String,Object> entity= new HashMap<>();
		entity.put("responseMessage", "Inavlid request body" );
		entity.put("responseCode", 500);
		return Response.ok("Invalid request body" ).status(status).header("exception", "Inavlid request body").build();
	}

}

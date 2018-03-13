package com.vjay.jercyapp

import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

import com.vjay.jercyapp.model.InventoryItems
import com.vjay.jercyapp.model.Shipment
import com.vjay.jercyapp.model.ShipmentReq
import com.vjay.jercyapp.service.InventoryService

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

@Path("invapi")
class InventoryController {

	InventoryService service = InventoryService.getInstance();

	
	@GET
	@Path("sample")
	@Produces(MediaType.TEXT_PLAIN)
	public String sample() {
		return "sdfdsf"
	}
	
	@GET
	@Path("getInvList")
	@Produces(MediaType.APPLICATION_JSON)
	public String all() {
		JsonBuilder jsonBuilder = new JsonBuilder(service.getInventoryList());
		return jsonBuilder.toPrettyString();
	}

	@POST
	@Path("/addShipment")
	@Produces(MediaType.APPLICATION_JSON)
	public Map makeNewShipment(String shipmentReq) {
		def shipmentReqMap = new JsonSlurper().parseText(shipmentReq)
		def shipmentReqObj = new ShipmentReq(shipmentReqMap)
		JsonBuilder jsonBuilder = new JsonBuilder(service.addItem2Inventory(shipmentReqObj));
		return sonBuilder.toPrettyString();
	}

	@GET
	@Path("/getShipments")
	@Produces(MediaType.APPLICATION_JSON)  
	public List<Shipment> getShipmentList(){
		JsonBuilder jsonBuilder = new JsonBuilder( service.getShipmentList());
		return sonBuilder.toPrettyString();
	}
}

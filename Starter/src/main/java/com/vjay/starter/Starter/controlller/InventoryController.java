package com.vjay.starter.Starter.controlller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vjay.starter.Starter.model.InventoryItems;
import com.vjay.starter.Starter.model.Shipment;
import com.vjay.starter.Starter.model.ShipmentReq;
import com.vjay.starter.Starter.service.InventoryService;

@RestController
@RequestMapping("/invmanager")
public class InventoryController {
	
	@Autowired
	private InventoryService service;
	
	@RequestMapping("/getInvItems")
	public List<InventoryItems> all() {
		
		return service.getInventoryList();
	}
	
	@PostMapping
	@RequestMapping("/addShipment")
	public Map makeNewShipment(@RequestBody ShipmentReq shipmentReq) {
		return service.addItem2Inventory(shipmentReq);
	}
	
	@RequestMapping("/getShipments")
	public List<Shipment> getShipmentList(){
		return service.getShipmentList();
	}
	
}

package com.vjay.starter.Starter.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vjay.starter.Starter.model.InventoryItems;
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
	
}

package com.vjay.starter.Starter.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vjay.starter.Starter.dao.InventoryDao;
import com.vjay.starter.Starter.model.InventoryItems;
import com.vjay.starter.Starter.model.Shipment;
import com.vjay.starter.Starter.model.ShipmentReq;

@Service
public class InventoryService {
	
	@Autowired
	InventoryDao dao;
	
	public List<InventoryItems> getInventoryList() {
		List<InventoryItems> invItemsUnsorted = dao.getInventoryList()
		List<InventoryItems> sortedInvLIst = []
		invItemsUnsorted.groupBy({item-> item.itemId}).each({ groupEntry->
			List group = groupEntry.value	
			sortedInvLIst << group.sum()
			
		})
		println "SortedList:$sortedInvLIst"
		
		
		return sortedInvLIst;
	}
	
	public Map  addItem2Inventory(ShipmentReq shipmentReq) {
		return dao.addItem2Inventory(shipmentReq);
	}

	public Object addShipment() {
	     
		return null;
	}

	public List<Shipment> getShipmentList() {
		return dao.getShipmentList();
	}
	
}

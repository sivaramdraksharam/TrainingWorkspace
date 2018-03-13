package com.vjay.jercyapp.service;

import com.vjay.jercyapp.dao.InventoryDao
import com.vjay.jercyapp.model.InventoryItems
import com.vjay.jercyapp.model.Shipment
import com.vjay.jercyapp.model.ShipmentReq

@Singleton
public class InventoryService {
	
	
	InventoryDao dao= com.vjay.jercyapp.dao.InventoryDao.getInstance();
	
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


	public List<Shipment> getShipmentList() {
		return dao.getShipmentList();
	}
	
}

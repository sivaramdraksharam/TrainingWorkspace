package com.vjay.starter.Starter.dao

import java.util.List

import com.vjay.starter.Starter.model.InventoryItems
import com.vjay.starter.Starter.model.Shipment
import com.vjay.starter.Starter.model.ShipmentReq

interface InventoryDao {
	
	List<InventoryItems> getInventoryList();
	Map addItem2Inventory(ShipmentReq shipmentReq)
	List<Shipment> getShipmentList();
	void removeInvbyBid(List<BigDecimal> batchId)
	void updateShipmentStatus(List<BigDecimal> batchId,int status)
}

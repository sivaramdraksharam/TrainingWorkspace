package com.vjay.starter.Starter.dao

import java.util.List

import com.vjay.starter.Starter.model.InventoryItems

interface InventoryDao {
	
	List<InventoryItems> getInventoryList();
	boolean addItem2Inventory();
}

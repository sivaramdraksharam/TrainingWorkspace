package com.vjay.starter.Starter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vjay.starter.Starter.dao.InventoryDao;
import com.vjay.starter.Starter.model.InventoryItems;

@Service
public class InventoryService {
	
	@Autowired
	InventoryDao dao;
	
	public List<InventoryItems> getInventoryList() {
		return dao.getInventoryList();
	}
	
	public void addItem2Inventory() {
		
	}
	
}

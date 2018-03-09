package com.vjay.starter.Starter.model

import groovy.transform.Canonical

@Canonical
class InventoryItems {
	String itemId;
	String itemName;
	BigDecimal price;
	int availableQty
	
}

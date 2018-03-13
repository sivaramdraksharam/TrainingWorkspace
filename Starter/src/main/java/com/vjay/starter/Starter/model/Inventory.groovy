package com.vjay.starter.Starter.model

import groovy.transform.Canonical

@Canonical
class Inventory {
	long serialNo;
	//String itemId;
	
	long batchId;
	int availableQty
	ShopItem item
}

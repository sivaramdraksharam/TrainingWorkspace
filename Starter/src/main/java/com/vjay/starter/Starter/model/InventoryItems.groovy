package com.vjay.starter.Starter.model

import groovy.transform.Canonical

@Canonical
class InventoryItems {
	String itemId;
	String itemName;
	BigDecimal price;
	int availableQty

	InventoryItems plus(InventoryItems item) {
		return new InventoryItems(itemId:this.itemId,itemName:this.itemName,
		price:this.price,availableQty:this.availableQty+item.availableQty)
	}
}

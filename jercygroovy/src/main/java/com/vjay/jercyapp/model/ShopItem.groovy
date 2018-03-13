package com.vjay.jercyapp.model


abstract class  ShopItem {
	Long itemId;
	String itemName;
	BigDecimal price;

	abstract boolean isKidHazardous();
}

package com.vjay.starter.Starter.model


abstract class  ShopItem {
	Long itemId;
	String itemName;
	BigDecimal price;

	abstract boolean isKidHazardous();
}

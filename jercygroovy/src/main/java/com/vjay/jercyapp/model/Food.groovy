package com.vjay.jercyapp.model;

import com.vjay.jercyapp.constants.FoodCategory
import groovy.transform.Canonical

@Canonical
public class Food extends ShopItem{

	FoodCategory category
	Date dateOfManufacture
	int noOfDayforExpiry

	@Override
	public boolean isKidHazardous() {
		return false;
	}
}

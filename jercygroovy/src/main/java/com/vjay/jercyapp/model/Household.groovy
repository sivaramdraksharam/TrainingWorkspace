package com.vjay.jercyapp.model

import com.vjay.jercyapp.constants.HouseholdCategory

class Household extends ShopItem{

	String brand;
	HouseholdCategory category;

	@Override
	public boolean isKidHazardous() {
		return true;
	}
}

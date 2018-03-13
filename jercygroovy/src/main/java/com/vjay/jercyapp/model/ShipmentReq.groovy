package com.vjay.jercyapp.model

import groovy.transform.Canonical

@Canonical
class ShipmentReq {
	String itemid
	int quantity
	Date shipmentDate,renewalDate
}

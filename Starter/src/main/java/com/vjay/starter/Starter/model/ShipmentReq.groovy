package com.vjay.starter.Starter.model

import groovy.transform.Canonical

@Canonical
class ShipmentReq {
	String itemid
	int quantity
	Date shipmentDate,renewalDate
}

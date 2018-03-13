package com.vjay.jercyapp;

import com.vjay.jercyapp.dao.InventoryDao;
import com.vjay.jercyapp.model.ShipmentReq
import com.vjay.jercyapp.util.PropsUtil
import java.util.Calendar.*;

public class TestFun {

	public static void main(String[] args) {
		InventoryDao dao = InventoryDao.getInstance()
		
		println dao.inventoryList
		println dao.getShipmentList()
		
		/*ShipmentReq req = new ShipmentReq(itemid: 'ITM1000',quantity:15,shipmentDate:new Date('03/12/2018'),renewalDate:new Date('03/22/2018'));
		dao.addItem2Inventory(req);  */
	/*	
		File file = new File(getClass().getResource("/dbconfig.properties")?.toURI())
		PropsUtil props = new PropsUtil(file);
		println props.connection_url
		assert props.connection_url.equals("jdbc://localhost:443")
		*/
		
	}
}

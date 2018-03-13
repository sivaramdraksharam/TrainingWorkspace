package com.vjay.jercyapp.dao

import com.vjay.jercyapp.model.Inventory
import com.vjay.jercyapp.model.InventoryItems
import com.vjay.jercyapp.model.Shipment
import com.vjay.jercyapp.model.ShipmentReq
import com.vjay.jercyapp.model.User
import com.vjay.jercyapp.util.DBUtil

import groovy.sql.Sql



@Singleton
public class InventoryDao {

	DBUtil dbutil = DBUtil.getInstance();

	List<User> getUSers(){
		try {
			Sql sqlInstance = dbutil.sqlInstance
			sqlInstance.eachRow('SELECT * FROM TestTable'){ row-> println "New:$row.tid - $row.name"  }
		}catch(Exception e) {
			e.printStackTrace()
		}
	}


	List<InventoryItems> getInventoryList(){
		def invList = []
		String query = """
						select a.itemid,b.itemname,b.price,a.availableqty 
						from inventory as a
						join shopitem as b 
						on a.itemid = b.itemid
					"""
		try {

			dbutil.sqlInstance.eachRow(query){ row->
				invList << new InventoryItems(row.itemid,row.itemname,row.price,row.availableqty)
			}
			return invList
		}catch(Exception e) {
			e.printStackTrace()
		}
	}


	Map addItem2Inventory(ShipmentReq req) {
		Calendar calender1 = new GregorianCalendar()

		calender1.setTime(req.renewalDate);
		String renewalDate =  calender1.get(Calendar.YEAR)+"-"+calender1.get(Calendar.MONTH)+"-"+calender1.get(Calendar.DAY_OF_MONTH)

		calender1.setTime(req.shipmentDate);
		String shipmentDate = calender1.get(Calendar.YEAR)+"-"+calender1.get(Calendar.MONTH)+"-"+calender1.get(Calendar.DAY_OF_MONTH)

		String query = "insert into shipment(shipmentDate,renewalDate,quantity,status) values('$shipmentDate','$renewalDate',$req.quantity,1)"
		println query
		def sql = dbutil.sqlInstance
		try {
			sql.withTransaction{
				def id = sql.executeInsert(query);
				int newBatchid =  id.get(0).get(0);
				Inventory inv = addItemtoInv(req.itemid, newBatchid, req.quantity)
				Map response = [
					invenoryInfo :inv
				]
				return response;
			}
		}catch(Exception ex) {
			
			println "Excption :$ex.message"
		}
	}

	Inventory addItemtoInv(String itemId,int batchId,int qnty) {
		String query = "insert into inventory (itemid, batchId, availableqty) values('$itemId',$batchId,$qnty)"
		def id = dbutil.sqlInstance.executeInsert(query);
		int newSerialNo =  id.get(0).get(0);
		Inventory inv = new Inventory()
		inv.serialNo= newSerialNo
		inv.availableQty = qnty
		inv.batchId = batchId
		return inv
	}

	List<Shipment> getShipmentList(){
		def shipmentList = []
		String query = "select * from  shipment"
		try {
			dbutil.sqlInstance.eachRow(query){ row->
				shipmentList << new Shipment(row.batchid,row.shipmentdate,row.shipmentdate,row.quantity,row.quantity)
			}
			return shipmentList
		}catch(Exception e) {
			e.printStackTrace()
		}
	}

	void removeInvbyBid(List<BigDecimal> batchId) {
		
		String deleteQuery = "delete from inventory where batchId in (:bids)"
		def sql = dbutil.sqlInstance
		sql.execute(deleteQuery)
		int count  = sql.updateCount
		println "NO of rows deleted:$count"
	}
	void updateShipmentStatus(List<BigDecimal> batchId,int status) {
		def bids = batchId.join(",")
		String updateQuery = "update shipment set status = $status where batchId in ($bids)"
		
		def sql = dbutil.sqlInstance
		sql.execute updateQuery
		println "NO of rows updated:$sql.updateCount"
	}
}

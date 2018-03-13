package com.vjay.starter.Starter.dao

import java.awt.geom.Point2D.Double
import java.math.BigDecimal
import java.sql.ResultSet
import java.util.List

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.core.namedparam.SqlParameterSource
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.jdbc.support.KeyHolder
import org.springframework.stereotype.Repository

import com.vjay.starter.Starter.model.Inventory
import com.vjay.starter.Starter.model.InventoryItems
import com.vjay.starter.Starter.model.Shipment
import com.vjay.starter.Starter.model.ShipmentReq
import com.vjay.starter.Starter.model.ShopItem

@Repository
class InventoryDaoGroovyImpl implements InventoryDao {
	
	//@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	
	
	@Override
	public List<InventoryItems> getInventoryList() {
		String query = """
						select a.itemid,b.itemname,b.price,a.availableqty 
						from inventory as a
						join shopitem as b 
						on a.itemid = b.itemid
					"""

		def rowMapDef = {ResultSet rs,int arg1 ->			
			new InventoryItems(rs.getString(1),rs.getString(2),new BigDecimal(rs.getDouble(3)),rs.getInt(4))
		}
		RowMapper rowMapper = rowMapDef;
		namedJdbcTemplate.query(query,rowMapper );
	}

	@Override
	public Map addItem2Inventory(ShipmentReq shipmentReq) {
		String query = "insert into shipment(shipmentDate,renewalDate,quantity) values(:shipmentDate,:renewalDate,:qnty)"
		println "Req: $shipmentReq" 
		KeyHolder holder = new GeneratedKeyHolder();
		def paramMap = [
			shipmentDate: shipmentReq.getShipmentDate(),
			renewalDate: shipmentReq.getRenewalDate(),
			qnty: shipmentReq.getQuantity()
			]

		SqlParameterSource params = new MapSqlParameterSource(paramMap) 
		
		namedJdbcTemplate.update(query,params, holder) 
		println "Inserted new row Id:"+holder.key.intValue()
		Inventory inv = addItemtoInv(shipmentReq.getItemid() ,holder.key.intValue() , shipmentReq.getQuantity()) 
		Map response = [
				invenoryInfo :inv	
			]
		return response;
	}
	
	Inventory addItemtoInv(String itemId,int batchId,int qnty) {
		String query = "insert into inventory (itemid, batchId, availableqty) values(:itemid,:batchId,:availableqty)"
		def paramMap = [
			itemid: itemId,
			batchId: batchId,
			availableqty: qnty
			]
		SqlParameterSource params = new MapSqlParameterSource(paramMap)
		KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(query,params, holder)
		Inventory inv = new Inventory()
		inv.serialNo= holder.key.intValue()
		inv.availableQty = qnty
		inv.batchId = batchId
		return inv
	}	
	
	@Override
	List<Shipment> getShipmentList() { 
		String query = "select * from  shipment"
		def rowMapDef = {ResultSet rs,int arg1 ->
			new Shipment(batchId: rs.getInt(1),shipmentDate: rs.getTimestamp(2),renewalDate: rs.getTimestamp(3),quantity:rs.getInt(4), invStatus: rs.getInt(5))    
		} 
		RowMapper rowMapper = rowMapDef;
		namedJdbcTemplate.query(query,rowMapper );
		
	}

	@Override
	public void removeInvbyBid(List<BigDecimal> batchId) {
		String deleteQuery = "delete from inventory where batchId in (:bids)"
		Map param = [ bids:  batchId]		
		
		int count  = namedJdbcTemplate.update(deleteQuery,param);
		println "NO of rows deleted:$count"
	}
	
	public void updateShipmentStatus(List<BigDecimal> batchId,int status) {
		String deleteQuery = "update shipment set status = :status where batchId in (:bids)"
		Map param = [ status : status,bids:  batchId]
		
		int count  = namedJdbcTemplate.update(deleteQuery,param);
		println "NO of rows updated:$count"
	}

	

}

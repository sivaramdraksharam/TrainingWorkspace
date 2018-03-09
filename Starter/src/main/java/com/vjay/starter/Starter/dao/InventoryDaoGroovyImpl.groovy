package com.vjay.starter.Starter.dao

import java.sql.ResultSet

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

import com.vjay.starter.Starter.model.Inventory
import com.vjay.starter.Starter.model.InventoryItems

@Repository
class InventoryDaoGroovyImpl implements InventoryDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<InventoryItems> getInventoryList() {
		String query = """
						select a.itemid,b.itemname,b.price,a.availableqty 
						from inventory as a
						join shopitem as b 
						on a.itemid = b.itemid
					"""

		def rowMapDef = {ResultSet rs,int arg1 ->
			ObjectGraphBuilder builder = new ObjectGraphBuilder(classLoader: getClass().classLoader )
			Inventory invItem = builder.'inventory'(serialNo:rs.getInt(1),batchId:rs.getInt(2), availableQty:rs.getInt(3)){
				food()
			}
			
			new InventoryItems(rs.getString(1),rs.getString(2),new BigDecimal(rs.getDouble(3)),rs.getInt(4))
		}
		RowMapper rowMapper = rowMapDef;
		jdbcTemplate.query(query,rowMapper );
	}

	@Override
	public boolean addItem2Inventory() {
		return false;
	}
}

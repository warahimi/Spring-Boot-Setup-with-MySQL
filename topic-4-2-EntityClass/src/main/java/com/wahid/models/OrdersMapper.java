package com.wahid.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

// this class is used to map the properties of the OrderModel to the database table
// since our row names does not match the OrderModel properties names
// this class build a bridge between the model properties and the table columns if they 
// do not have the same spelling. 
public class OrdersMapper implements RowMapper<OrderModel>{

	/*
	 	ResultSet rs is somthing that comes from the database 
	 	we take rs and interprete it to the OrderModel
	 	
	 */
	@Override
	public OrderModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		// 1 get the result set 
		
		// 2 create a new Order Model object
		OrderModel orderModel = new OrderModel(rs.getLong("ID"),
				rs.getString("ORDER_NUMBER"),
				rs.getString("PRODUCT_NAME"),
				rs.getFloat("PRICE"),
				rs.getInt("QUANTITY")
				);
		
		// 3 return it
		return orderModel;
	}

}

package com.wahid.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.ui.context.Theme;

import com.wahid.models.OrderModel;
import com.wahid.models.OrdersMapper;

@Repository // telling spring it is a managed bean
@Primary
public class OrderDataService implements OrdersDataAccessInterface{
	
	// Creating a connection to the database 
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public OrderModel getById(Long id) {
		List<OrderModel> resultModel = jdbcTemplate.query("SELECT * FROM ORDERS WHERE ID = ?",
				new OrdersMapper(), id);
		if(resultModel.size()> 0)
			return resultModel.get(0);
		return null;
	}

	@Override
	public List<OrderModel> getOrders() {
		List<OrderModel> resutls = jdbcTemplate.query("SELECT * FROM ORDERS", new OrdersMapper());
		return resutls;
	}

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		List<OrderModel> results = jdbcTemplate.query("SELECT * FROM ORDERS WHERE PRODUCT_NAME LIKE ?",
				new OrdersMapper(), "%" + searchTerm + "%");
		if(results.size() > 0)
			return results;
		return null;
	}

	@Override
	public Long addOne(OrderModel newOrder) {
//		// this returns the number of rows affected in our database 
//		Long result =  (long) jdbcTemplate.update("INSERT INTO `orders` (`ORDER_NUMBER`, `PRODUCT_NAME`, `PRICE`, `QUANTITY`) VALUES (?,?,?,?)",
//				newOrder.getOrderNo(),
//				newOrder.getProductName(),
//				newOrder.getPrice(),
//				newOrder.getQuantity());
//		return result; // return the number of rows affected 
		
		// to get the ID of the product added and return the id 
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("ORDERS").usingGeneratedKeyColumns("ID");
		
		//Create a map of the col names
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("ORDER_NUMBER", newOrder.getOrderNo());
		parameters.put("PRODUCT_NAME", newOrder.getProductName());
		parameters.put("PRICE", newOrder.getPrice());
		parameters.put("QUANTITY", newOrder.getQuantity());
		
		// Number is wrapper class for all numbers
		Number result =  simpleJdbcInsert.executeAndReturnKey(parameters);
		return result.longValue();
	}

	@Override
	public boolean deleteOne(Long id) {
		int result = jdbcTemplate.update("DELETE FROM ORDERS WHERE ID = ?", id);
		return result > 0 ? true : false;
	}

	@Override
	public OrderModel updateOne(Long id, OrderModel updateOrder) {
		// return the number of records changed 
		int result = jdbcTemplate.update("UPDATE ORDERS SET ORDER_NUMBER = ?, PRODUCT_NAME = ?, PRICE = ?, QUANTITY = ? WHERE ID = ?",
				updateOrder.getOrderNo(),
				updateOrder.getProductName(),
				updateOrder.getPrice(),
				updateOrder.getQuantity(),
				id);
		return result > 0 ? updateOrder : null;
	}

}

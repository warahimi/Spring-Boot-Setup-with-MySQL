package com.wahid.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wahid.models.OrderEntity;

public interface OrdersRepositoryInterface extends CrudRepository<OrderEntity, Long>{
	// use the CrudeRepository class in Spring to do the data operations on MySQL
	
	// Beside the Builtin CrudRepository methods such as save, findall, deletebyid .. ect.
	
	
	// We can implement our own custom queries on the database here such as searching ... etc.
	
	List<OrderEntity> findByProductNameContainingIgnoreCase(String searchTerm);

	

}

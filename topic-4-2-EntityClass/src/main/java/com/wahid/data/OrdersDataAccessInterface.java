package com.wahid.data;

import java.util.List;

import com.wahid.models.OrderModel;

public interface OrdersDataAccessInterface<T>{
	public OrderModel getById(Long id);
	public List<T> getOrders();
	public List<T> searchOrders(String searchTerm);
	public Long addOne(T newOrder);
	public boolean deleteOne(Long id);
	// return the updated order , take the id or order to update to updateOrder
	public T updateOne(Long id, T updateOrder);

}

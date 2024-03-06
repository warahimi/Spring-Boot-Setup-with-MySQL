package com.wahid.data;

import java.util.List;

import com.wahid.models.OrderModel;

public interface OrdersDataAccessInterface {
	public OrderModel getById(Long id);
	public List<OrderModel> getOrders();
	public List<OrderModel> searchOrders(String searchTerm);
	public Long addOne(OrderModel newOrder);
	public boolean deleteOne(Long id);
	// return the updated order , take the id or order to update to updateOrder
	public OrderModel updateOne(Long id, OrderModel updateOrder);

}

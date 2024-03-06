package com.wahid.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wahid.models.OrderModel;

@Repository
public class OrdersFakeDAO implements OrdersDataAccessInterface{
	List<OrderModel> orders = new ArrayList<>();

	

	public OrdersFakeDAO() {
		super();
		orders.add(new OrderModel(0L, "0000", "Sky Diving2", 12.4f, 1));
		orders.add(new OrderModel(1L, "1111", "Monitor2", 12.4f, 1));
		orders.add(new OrderModel(2L, "2222", "Computer2", 12.4f, 1));
		orders.add(new OrderModel(3L, "3333", "Sky Diving2", 12.4f, 1));
		orders.add(new OrderModel(4L, "4444", "Sky Diving2", 12.4f, 1));
		orders.add(new OrderModel(5L, "5555", "Sky Diving2", 12.4f, 1));
		orders.add(new OrderModel(6L, "6666", "Jumping2", 12.4f, 1));
		orders.add(new OrderModel(6L, "9999", "Jumping2", 12.4f, 1));

	}

	@Override
	public OrderModel getById(Long id) {
		for(int i = 0; i < orders.size(); i++)
		{
			if(orders.get(i).getId() == id)
			{
				return orders.get(i);
			}
		}
		// nothing found 
		return null;
	}

	@Override
	public List<OrderModel> getOrders() {
		return orders;
	}

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		List<OrderModel> result = new ArrayList<>();
		for(int i = 0; i < orders.size(); i++)
		{
			if(orders.get(i).getProductName().toLowerCase().contains(searchTerm.toLowerCase()))
			{
				result.add(orders.get(i));
			}
		}
		return result;
	}

	@Override
	public Long addOne(OrderModel newOrder) {
		boolean success = orders.add(newOrder);
		if(success)
			return 1L;
		return 0L;
	}

	@Override
	public boolean deleteOne(Long id) {
		for(int i = 0; i < orders.size(); i++)
		{
			if(orders.get(i).getId() == id)
			{
				orders.remove(i);
				return true;
			}
		}
		// nothing found 
		return false;
	}

	@Override
	public OrderModel updateOne(Long id, OrderModel updateOrder) {
		for(int i = 0; i < orders.size(); i++)
		{
			if(orders.get(i).getId() == id)
			{
				orders.set(i, updateOrder);
				return orders.get(i);
			}
		}
		return null;
	}

}

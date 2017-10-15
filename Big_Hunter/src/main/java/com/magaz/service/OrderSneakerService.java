package com.magaz.service;

import java.util.List;

import com.magaz.entity.OrderSneaker;
import com.magaz.entity.OrderSneakerId;
import com.magaz.entity.Orders;
import com.magaz.entity.Sneaker;

public interface OrderSneakerService {
	
	void save(OrderSneaker orderSneaker);
	
	List<OrderSneaker> findAll();
	
	OrderSneaker findOne(OrderSneakerId orderSneakerId);
	
	void delete (OrderSneakerId orderSneakerId);
	
	void update(OrderSneaker orderSneaker);
	
	OrderSneaker findOrderAndSneaker(Orders order,Sneaker sneaker);

}

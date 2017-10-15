package com.magaz.service;

import java.security.Principal;
import java.util.List;

import com.magaz.entity.Orders;
import com.magaz.entity.Sneaker;
import com.magaz.entity.User;

public interface OrdersService  {

	void save(Orders order);

	List<Orders> findAll();

	Orders findOne(int id);

	void delete(int id);

	void update(Orders order);

	void addToCart(Principal principal, int id,int oQuantity);
	
	void deleteFromBasket(int userId,int sneakerId);

	void buy(int userId);
	
	Orders findOrderWithOrderSneaker(int id);
	
//	Orders findOrderByUser(User user);
	
}

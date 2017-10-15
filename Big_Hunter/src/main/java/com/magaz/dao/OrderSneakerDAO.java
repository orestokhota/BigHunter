package com.magaz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.magaz.entity.OrderSneaker;
import com.magaz.entity.OrderSneakerId;
import com.magaz.entity.Orders;
import com.magaz.entity.Sneaker;

public interface OrderSneakerDAO extends JpaRepository<OrderSneaker, OrderSneakerId> {

	
	@Query("select o from OrderSneaker o where o.id.order =:order and o.id.sneaker=:sneaker")
	OrderSneaker findOrderAndSneaker(@Param("order")Orders order, @Param("sneaker")Sneaker sneaker);

	@Query("select o from OrderSneaker o where o.id.order=:order")
	OrderSneaker findOrder(@Param("order") Orders order);
}

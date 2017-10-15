package com.magaz.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.magaz.entity.Orders;
import com.magaz.entity.Sneaker;
import com.magaz.entity.User;

public interface OrdersDAO extends JpaRepository<Orders, Integer> {
	
	
	@Query("select o from Orders o left join fetch o.orderSneakers where o.id=:id")
	Orders findOrderWithOrderSneaker(@Param("id")int id);
	
	
	Orders findOrderByUser(User user);
	
	@Query("select distinct o from Orders o left join fetch o.orderSneakers where o.user=:user")
    List<Orders> findOrdersWithOrderSneakerByUser(@Param("user") User user);
	
	@Query("select o from Orders o left join fetch o.orderSneakers where o.id=:id")
	Orders orderWithOrderSneaker(@Param("id")int id);
	
	
}

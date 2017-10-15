package com.magaz.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magaz.dao.OrderSneakerDAO;
import com.magaz.entity.OrderSneaker;
import com.magaz.entity.OrderSneakerId;
import com.magaz.entity.Orders;
import com.magaz.entity.Sneaker;
import com.magaz.service.OrderSneakerService;
@Service
public class OrderSneakerServiceImpl implements OrderSneakerService{

	@Autowired
	private OrderSneakerDAO orderSneakerDao;
	
	
	@Override
	public void save(OrderSneaker orderSneaker) {
		orderSneakerDao.save(orderSneaker);
	}

	@Override
	public List<OrderSneaker> findAll() {
		return orderSneakerDao.findAll();
	}

	@Override
	public OrderSneaker findOne(OrderSneakerId orderSneakerId) {
		return orderSneakerDao.findOne(orderSneakerId);
	}

	@Override
	public void delete(OrderSneakerId orderSneakerId) {
		orderSneakerDao.delete(orderSneakerId);
	}

	@Override
	public void update(OrderSneaker orderSneaker) {
		orderSneakerDao.save(orderSneaker);
	}

	@Override
	public OrderSneaker findOrderAndSneaker(Orders order, Sneaker sneaker) {
		return orderSneakerDao.findOrderAndSneaker(order, sneaker);
	}

}

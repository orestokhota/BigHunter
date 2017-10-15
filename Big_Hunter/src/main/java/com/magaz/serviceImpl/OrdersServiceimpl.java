package com.magaz.serviceImpl;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.TableGenerator;
import javax.transaction.Transactional;

import org.hibernate.id.IncrementGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magaz.dao.OrderSneakerDAO;
import com.magaz.dao.OrdersDAO;
import com.magaz.dao.SneakerDAO;
import com.magaz.dao.UserDAO;
import com.magaz.entity.OrderSneaker;
import com.magaz.entity.OrderSneakerId;
import com.magaz.entity.Orders;
import com.magaz.entity.Sneaker;
import com.magaz.entity.User;
import com.magaz.service.OrdersService;

@Service
public class OrdersServiceimpl implements OrdersService {
	@Autowired
	private OrdersDAO ordersDAO;
	@Autowired
	private UserDAO userDao;

	@Autowired
	private SneakerDAO sneakerDao;

	@Autowired
	private OrderSneakerDAO orderSneakerDao;

	public void save(Orders order) {
		ordersDAO.save(order);
	}

	public List<Orders> findAll() {
		return ordersDAO.findAll();
	}

	public Orders findOne(int id) {
		return ordersDAO.findOne(id);
	}

	public void delete(int id) {
		ordersDAO.delete(id);
	}

	public void update(Orders order) {
		ordersDAO.save(order);
	}

	public void addToCart(Principal principal, int id, int oQuantity) {

		User user = userDao.findUserWithSneaker(Integer.parseInt(principal.getName()));

		Sneaker sneaker = sneakerDao.findOne(id);

		Orders orders = new Orders(LocalDateTime.now());
		if(sneaker.getQuantity() >= oQuantity){

		OrderSneaker currentOrderSneaker = new OrderSneaker(new OrderSneakerId(orders, sneaker), oQuantity);
		orders.getOrderSneakers().add(currentOrderSneaker);
		ordersDAO.saveAndFlush(orders);
		orderSneakerDao.saveAndFlush(currentOrderSneaker);

		user.getSneakers().add(sneaker);
		
		userDao.save(user);
		}else{
			System.out.println("error");
			
		}
	}

	@Transactional
	public void deleteFromBasket(int userId, int sneakerId) {

		User user = userDao.findUserWithSneaker(userId);

		Sneaker sneaker = sneakerDao.findOne(sneakerId);
		

		user.getSneakers().remove(sneaker);

		userDao.save(user);

	}

	@Transactional
	public void buy(int userId) {
		
		
		
		List<Orders> currentOrders = ordersDAO.findOrdersWithOrderSneakerByUser(userDao.findOne(userId));
		Orders lastOrder = currentOrders.get(currentOrders.size()-1);
		User user = userDao.findUserWithSneaker(userId);

		
		
		List<OrderSneaker> orderSneakers = lastOrder.getOrderSneakers();
		for (Sneaker sneaker: user.getSneakers()) {
			for(OrderSneaker currentOrderSneaker: orderSneakers) {
				if (sneaker.getId() == currentOrderSneaker.getSneaker().getId()) {
					sneaker.setQuantity(sneaker.getQuantity() - currentOrderSneaker.getQuantityForBuy());
					sneakerDao.saveAndFlush(sneaker);
				}
				orderSneakerDao.saveAndFlush(currentOrderSneaker);
			}
		}
		
		user.getSneakers().clear();
		userDao.save(user);

	}

	@Override
	public Orders findOrderWithOrderSneaker(int id) {
		return ordersDAO.findOrderWithOrderSneaker(id);
	}

}

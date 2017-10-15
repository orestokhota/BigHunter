package com.magaz.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.magaz.entity.Sneaker;
import com.magaz.entity.User;

public interface UserService {

	void save(User user) throws Exception;

	List<User> findAll();

	User findOne(int id);

	void delete(int id);

	void update(User user);

	void joinUserWithSneaker(int userId, int sneakerId);

	User findByName(String name);

	User findByEmail(String email);

	User findByPassword(String password);

	User findUserWithSneaker(int id);
	
	User findUserByUUID(String uuid);

	User findUserWithOrder(int id);
	
	User findUserWithOrderSneaker(int id);
	
	User findUserWithSneakerWithAllParam(int id);

}

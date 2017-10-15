package com.magaz.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.magaz.dao.SneakerDAO;
import com.magaz.dao.UserDAO;
import com.magaz.entity.Role;
import com.magaz.entity.Sneaker;
import com.magaz.entity.User;
import com.magaz.service.UserService;
import com.magaz.validator.Validator;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDAO userDao;

	@Autowired
	private SneakerDAO snDao;

	@Autowired
	@Qualifier("userValidator")
	private Validator validator;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public void save(User user) throws Exception {
		validator.validate(user);
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));

		userDao.save(user);

	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findOne(int id) {
		return userDao.findOne(id);
	}

	public void delete(int id) {
		userDao.delete(id);
	}

	public void update(User user) {
		userDao.save(user);
	}

	public void joinUserWithSneaker(int userid, int sneakerid) {
		User user = userDao.findOne(userid);

		Sneaker sn = snDao.findOne(sneakerid);

		sn.getUsers().add(user);

		snDao.save(sn);

	}

	@Override
	public User findByName(String name) {
		return userDao.findByName(name);
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public User findByPassword(String password) {
		return userDao.findByPassword(password);
	}

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		return userDao.findByName(name);
	}

	@Override
	public User findUserWithSneaker(int id) {
		 return userDao.findUserWithSneaker(id);

//		User returnedUser = new User();
//
//		returnedUser.setId(user.getId());
//		returnedUser.setName(user.getName());
//
//		for (int i = 0; i < user.getSneakers().size(); i++) {
//			returnedUser.getSneakers()
//					.add(new Sneaker(user.getSneakers().get(i).getPrice(), user.getSneakers().get(i).getQuantity()));
//
//		}
//		
		

	}

	@Override
	public User findUserByUUID(String uuid) {
		return userDao.findUserByUUID(uuid);
	}

	@Override
	public User findUserWithOrder(int id) {
		return userDao.findUserWithOrder(id);
	}

	@Override
	public User findUserWithOrderSneaker(int id) {
		return userDao.findUserWithOrderSneaker(id);
	}

	@Override
	public User findUserWithSneakerWithAllParam(int id) {
		return userDao.findUserWithSneakerAllParam(id);
	}

}

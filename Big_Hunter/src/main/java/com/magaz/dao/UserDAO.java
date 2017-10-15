package com.magaz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.magaz.entity.User;

public interface UserDAO extends JpaRepository<User, Integer> {

//	void save(User user);
//	List<User> findAll();
//	 User findOne(String name);
//	void delete(String name,String email);
//	void update(User user);
	
//	@Query("select u from User u where u.name =:param1 and u.email=:param2")
//	User findUserByNameAndEmail(@Param("param1")String name,@Param("param2")String email);
	
	User findByNameAndEmail(String name,String email);
	
	
	@Query("select u from User u left join fetch u.sneakers where u.id =:id")
	User findUserWithSneaker(@Param("id") int id);
	
	@Query("select u from User u where u.uuid =:uuid")
	User findUserByUUID(@Param("uuid") String uuid);
	
	User findByName(String name);
	 
	User findByEmail(String email);
	
	User findByPassword(String password);
	
	@Query("select distinct u from User u left join fetch u.orders o left join fetch o.sneakers where u.id=:id")
	User findUserWithOrder(@Param("id")int id);
	
	@Query("select distinct u from User u left join fetch u.sneakers s left join fetch s.orderSneakers where u.id=:id")
	User findUserWithOrderSneaker(@Param("id") int id);

	@Query("select distinct u from User u left join fetch u.sneakers s left join fetch s.orderSneakers "
			+ " left join fetch s.brends  left join fetch s.models  left join fetch s.size where u.id=:id")
	User findUserWithSneakerAllParam(@Param("id") int id);

}




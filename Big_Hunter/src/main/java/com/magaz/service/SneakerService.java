package com.magaz.service;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.magaz.entity.Brend;
import com.magaz.entity.SModel;
import com.magaz.entity.Sneaker;

public interface SneakerService {

	void save(Sneaker sneaker, int brendid,int modelId, int typeid,int sizeid) throws Exception;

	List<Sneaker> findAll();

	Sneaker findOne(int id);

	void delete(int id);

	void update(Sneaker sneaker,int brendId,int modelId,int typeId,int sizeId) throws Exception;

	Sneaker sneakerWithAll(int id);
	Sneaker sneakerWithBrend(int id);
	Sneaker sneakerWithModel(int id);
	Sneaker sneakerWithType(int id);
	Sneaker sneakerWithSize(int id);

	Set<Sneaker> sneakerWithBrends();

	Set<Sneaker> sneakerWithModels();
	

	Set<Sneaker> sneakerWithTypes();
	
	Set<Sneaker> sneakerWithSizes();
	
	Set<Sneaker> sneakerWithAllInfo(int id);
	
//	Sneaker findSneakerWithBrendAndModel(int id);
	
	Page<Sneaker>findAll(Pageable pageable);
	
	Page<Sneaker> sneakerWithModelPages(Pageable pageable);
	
	Sneaker sneakerWithOrderSneaker(int id);
	
	Set<Sneaker> searchSneakerByModelName(String search);
}

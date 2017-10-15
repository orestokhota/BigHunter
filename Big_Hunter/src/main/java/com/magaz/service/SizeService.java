package com.magaz.service;

import java.util.List;

import com.magaz.entity.Sizes;


public interface SizeService {

	void save(Sizes size) throws Exception;

	List<Sizes> findAll();

	Sizes findOne(int id);

	void delete(int id);

	void update(Sizes size) throws Exception;
	
	Sizes findBySize(String size);
	
	
}

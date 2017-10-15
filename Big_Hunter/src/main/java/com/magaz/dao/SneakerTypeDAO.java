package com.magaz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magaz.entity.SneakerType;

public interface SneakerTypeDAO extends JpaRepository<SneakerType, Integer>{
	
	SneakerType findByName(String name);
	

}

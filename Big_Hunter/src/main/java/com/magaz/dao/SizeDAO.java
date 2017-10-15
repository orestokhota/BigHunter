package com.magaz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.magaz.entity.Sizes;

public interface SizeDAO extends JpaRepository<Sizes, Integer>{
	
	Sizes findBySize(String size);
}

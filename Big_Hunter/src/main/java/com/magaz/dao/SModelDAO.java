package com.magaz.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.magaz.entity.SModel;

public interface SModelDAO extends JpaRepository<SModel, Integer>{
	
	SModel findByName(String name);
	
	@Query("select m from SModel m where m.name like %:search% ")
	List <SModel> searchModels (@Param ("search") String search);

}

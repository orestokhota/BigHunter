package com.magaz.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import com.magaz.entity.Brend;

public interface BrendDAO extends JpaRepository<Brend, Integer> {
	
	Brend findByName(String name);
	
//	@Query("select b from Brend b left join fetch b.models")
//	Set<Brend> brendWithModels();
//	
//	@Query("select b from Brend b left join fetch b.models where b.id=:id")
//	Brend brendWithModel(@Param("id")int id);

	
	
}

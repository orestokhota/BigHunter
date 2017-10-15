package com.magaz.service;

import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.magaz.entity.Brend;


public interface BrendService {

	void save(Brend brend) throws Exception;
	List<Brend> findAll();
	 Brend findOne(int id);
	void delete(int id);
	//void update(Brend brend);
	Brend findByName(String name);

	//Set<Brend> brendWithModels();
	
//	Brend brendWithModel(int id);
	
	void update(Brend brend) throws Exception;
	
}

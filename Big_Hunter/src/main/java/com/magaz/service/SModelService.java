package com.magaz.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.magaz.entity.SModel;


public interface SModelService {
	void save(SModel sModel,MultipartFile image) throws Exception;
	List<SModel> findAll();
	 SModel findOne(int id);
	void delete(int id);
	void update(SModel sModel,MultipartFile image) throws Exception;
	SModel findByName(String name);
	
	Page<SModel>findAll(Pageable pageable);
	
	List<SModel> searchModels(String search);


}

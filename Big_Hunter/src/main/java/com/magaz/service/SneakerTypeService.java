package com.magaz.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.magaz.entity.SneakerType;
import com.magaz.entity.User;

public interface SneakerTypeService {

	void save(SneakerType sneakerType) throws Exception;
	List<SneakerType> findAll();
	 SneakerType findOne(int id);
	void delete(int id);
	void update(SneakerType sneakerType) throws Exception;
	SneakerType findByName(String name);

}

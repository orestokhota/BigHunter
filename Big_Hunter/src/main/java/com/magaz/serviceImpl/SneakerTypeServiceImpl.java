package com.magaz.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.magaz.dao.SModelDAO;
import com.magaz.dao.SneakerDAO;
import com.magaz.dao.SneakerTypeDAO;
import com.magaz.entity.Sneaker;
import com.magaz.entity.SneakerType;
import com.magaz.service.SneakerService;
import com.magaz.service.SneakerTypeService;
import com.magaz.validator.Validator;

@Service
public class SneakerTypeServiceImpl implements SneakerTypeService {

	@Autowired
	private SneakerTypeDAO snTypeDao;

	@Autowired
	private SneakerDAO snDao;

	@Autowired
	@Qualifier("typeValidator")
	private Validator validator;

	@Override
	public void save(SneakerType sneakerType) throws Exception {

		validator.validate(sneakerType);

		snTypeDao.save(sneakerType);
	}

	@Override
	public List<SneakerType> findAll() {
		return snTypeDao.findAll();
	}

	@Override
	public SneakerType findOne(int id) {
		return snTypeDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		snTypeDao.delete(id);
	}

	@Override
	public void update(SneakerType sneakerType) throws Exception {
		validator.validate(sneakerType);
		snTypeDao.save(sneakerType);
	}

	@Override
	public SneakerType findByName(String name) {
		return snTypeDao.findByName(name);
	}

}

package com.magaz.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.magaz.dao.SizeDAO;
import com.magaz.entity.Sizes;
import com.magaz.service.SizeService;
import com.magaz.validator.Validator;
@Service
public class SizeServiceImpl implements SizeService{
		
	@Autowired
	private SizeDAO sizeDao;
	
	@Autowired
	@Qualifier("sizeValidator")
	private Validator validator;
	
	
	@Override
	public void save(Sizes size) throws Exception {
		validator.validate(size);
		sizeDao.save(size);
	}

	@Override
	public List<Sizes> findAll() {
		return sizeDao.findAll();
	}

	@Override
	public Sizes findOne(int id) {
		return sizeDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		sizeDao.delete(id);
	}

	@Override
	public void update(Sizes size) throws Exception {
		validator.validate(size);
		sizeDao.save(size);
	}

	@Override
	public Sizes findBySize(String size) {
		return sizeDao.findBySize(size);
	}

	
	

}

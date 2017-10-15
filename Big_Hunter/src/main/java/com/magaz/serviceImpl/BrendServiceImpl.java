package com.magaz.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.magaz.dao.BrendDAO;
import com.magaz.dao.SModelDAO;
import com.magaz.entity.Brend;
import com.magaz.entity.SModel;
import com.magaz.service.BrendService;
import com.magaz.validator.Validator;
@Service
public class BrendServiceImpl implements BrendService{
	
	
	@Autowired
	private SModelDAO modelDao;
	
	@Autowired
	private BrendDAO brendDao;
	
	@Autowired
	@Qualifier("brendValidator")
	private Validator validator;
	@Override
	public void save(Brend brend) throws Exception{
		
		validator.validate(brend);
		brendDao.save(brend);
	}

	@Override
	public List<Brend> findAll() {
		return brendDao.findAll();
	}

	@Override
	public Brend findOne(int id) {
		return brendDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		brendDao.delete(id);
	}
	@Transactional
	@Override
	public void update(Brend brend) throws Exception {
		
		
		
		validator.validate(brend);
		brendDao.save(brend);
		
		
		
	}

	@Override
	public Brend findByName(String name) {
		return brendDao.findByName(name);
	}

	

//	@Override
//	public Set<Brend> brendWithModels() {
//		return brendDao.brendWithModels();
//	}
//
//	@Override
//	public Brend brendWithModel(int id) {
//		return brendDao.brendWithModel(id);
//	}


	
	
	

}

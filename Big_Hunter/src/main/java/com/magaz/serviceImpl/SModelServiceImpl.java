package com.magaz.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.magaz.dao.SModelDAO;
import com.magaz.entity.SModel;
import com.magaz.service.SModelService;
import com.magaz.validator.Validator;
@Service
public class SModelServiceImpl implements SModelService {

	@Autowired
	private SModelDAO sModelDao;
	
	
	@Autowired
	@Qualifier("modelValidator")
	private Validator validator;
	@Override
	public void save(SModel model,MultipartFile image) throws Exception {
		
		validator.validate(model);
	sModelDao.saveAndFlush(model);
		
		String path = System.getProperty("catalina.home") + "/resources/"
				+ model.getName() + "/" + image.getOriginalFilename();
		
		model.setPathImage("/resources/" + model.getName() + "/" + image.getOriginalFilename());
		
		File filePath = new File(path);
		
		try{
			filePath.mkdirs();
			try{
				FileUtils.cleanDirectory
				(new File(System.getProperty("catalina.home") + "/resources/"
						+ model.getName() + "/" + image.getOriginalFilename()));
				
			}catch (IOException e) {
				e.printStackTrace();
			}
			image.transferTo(filePath);
		}catch (IOException e) {
			System.out.println("error with file");
		}
		
		
		sModelDao.save(model);
	}

	@Override
	public List<SModel> findAll() {
		return sModelDao.findAll();
	}

	@Override
	public SModel findOne(int id) {
		return sModelDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		sModelDao.delete(id);
	}

	@Override
	public void update(SModel model,MultipartFile image) throws Exception {
		validator.validate(model);
		sModelDao.saveAndFlush(model);
		
		String path = System.getProperty("catalina.home") + "/resources/"
				+ model.getName() + "/" + image.getOriginalFilename();
		
		model.setPathImage("/resources/" + model.getName() + "/" + image.getOriginalFilename());
		
		File filePath = new File(path);
		
		try{
			filePath.mkdirs();
			try{
				FileUtils.cleanDirectory
				(new File(System.getProperty("catalina.home") + "/resources/"
						+ model.getName() + "/" + image.getOriginalFilename()));
				
			}catch (IOException e) {
				e.printStackTrace();
			}
			image.transferTo(filePath);
		}catch (IOException e) {
			System.out.println("error with file");
		}
		
		
		sModelDao.save(model);
	}

	@Override
	public SModel findByName(String name) {
		return sModelDao.findByName(name);
	}

	@Override
	public Page<SModel> findAll(Pageable pageable) {
		return sModelDao.findAll(pageable);
	}

	@Override
	public List<SModel> searchModels(String search) {
		
		return sModelDao.searchModels(search);
	}

	
	
	
}

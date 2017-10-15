package com.magaz.serviceImpl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.taglibs.standard.tag.el.sql.SetDataSourceTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.magaz.dao.BrendDAO;
import com.magaz.dao.SModelDAO;
import com.magaz.dao.SizeDAO;
import com.magaz.dao.SneakerDAO;
import com.magaz.dao.SneakerTypeDAO;
import com.magaz.dao.UserDAO;
import com.magaz.entity.Brend;
import com.magaz.entity.SModel;
import com.magaz.entity.Sizes;
import com.magaz.entity.Sneaker;
import com.magaz.entity.SneakerType;
import com.magaz.entity.User;
import com.magaz.service.SneakerService;
import com.magaz.service.UserService;
import com.magaz.validator.Validator;

@Service
public class SneakerServiceImpl implements SneakerService {
	@Autowired
	private UserDAO userDao;

	@Autowired
	private SneakerDAO sneakerDao;
	@Autowired
	private BrendDAO brendDao;
	@Autowired
	private SModelDAO sModelDao;
	@Autowired
	private SneakerTypeDAO snTypeDao;
	@Autowired
	private SizeDAO sizeDao;

	@Autowired
	@Qualifier("sneakerValidator")
	private Validator validator;

	public List<Sneaker> findAll() {
		return sneakerDao.findAll();
	}

	public Sneaker findOne(int id) {
		return sneakerDao.findOne(id);
	}

	public void delete(int id) {
		sneakerDao.delete(id);

	}

	public void update(Sneaker sneaker, int brendId, int modelId, int typeId, int sizeId) throws Exception {
		// validator.validate(sneaker);
		sneakerDao.saveAndFlush(sneaker);
		Sizes size = sizeDao.findOne(sizeId);
		Brend brend = brendDao.findOne(brendId);
		SModel model = sModelDao.findOne(modelId);
		SneakerType snType = snTypeDao.findOne(typeId);
		sneaker.setSize(size);
		sneaker.getModels().add(model);
		sneaker.getBrends().add(brend);
		sneaker.getTypes().add(snType);

		sneakerDao.save(sneaker);
	}

	@Override
	public Sneaker sneakerWithAll(int id) {

		Sneaker sneakerB = sneakerDao.sneakerWithBrend(id);
		Sneaker sneakerM = sneakerDao.findSneakerWithModel(id);
		Sneaker sneakerT = sneakerDao.sneakerWithType(id);
		Sneaker sneakerS = sneakerDao.sneakerWithSize(id);

		Sneaker returnedSneaker = new Sneaker();

		returnedSneaker.setPrice(sneakerB.getPrice());
		returnedSneaker.setQuantity(sneakerB.getQuantity());
		returnedSneaker.setId(sneakerB.getId());
		returnedSneaker.setModels(sneakerM.getModels());
		returnedSneaker.setBrends(sneakerB.getBrends());
		returnedSneaker.setTypes(sneakerT.getTypes());
		returnedSneaker.setSize(sneakerS.getSize());

		return returnedSneaker;
	}

	@Override
	public void save(Sneaker sneaker, int brendid, int modelId, int typeid, int sizeid) throws Exception {
		// validator.validate(sneaker);
		sneakerDao.saveAndFlush(sneaker);

		Sizes size = sizeDao.findOne(sizeid);
		Brend brend = brendDao.findOne(brendid);
		SModel model = sModelDao.findOne(modelId);
		SneakerType snType = snTypeDao.findOne(typeid);
		sneaker.setSize(size);
		sneaker.getModels().add(model);
		sneaker.getBrends().add(brend);
		sneaker.getTypes().add(snType);

		sneakerDao.save(sneaker);

	}

	@Override
	public Set<Sneaker> sneakerWithBrends() {
		return sneakerDao.sneakerWithBrends();
	}

	@Override
	public Set<Sneaker> sneakerWithTypes() {
		return sneakerDao.sneakerWithTypes();
	}

	@Override
	public Set<Sneaker> sneakerWithModels() {
		return sneakerDao.sneakerWithModels();
	}

	@Override
	public Sneaker sneakerWithModel(int id) {
		return sneakerDao.findSneakerWithModel(id);
	}

	@Override
	public Set<Sneaker> sneakerWithAllInfo(int id) {
		Set<Sneaker> sneakers = new HashSet<>();
		Sneaker sneakerB = sneakerDao.sneakerWithBrend(id);
		Sneaker sneakerM = sneakerDao.findSneakerWithModel(id);
		Sneaker sneakerT = sneakerDao.sneakerWithType(id);
		Sneaker sneakerS = sneakerDao.sneakerWithSize(id);

		Sneaker returnedSneaker = new Sneaker();

		returnedSneaker.setPrice(sneakerB.getPrice());
		returnedSneaker.setQuantity(sneakerB.getQuantity());
		returnedSneaker.setId(sneakerB.getId());
		returnedSneaker.setModels(sneakerM.getModels());
		returnedSneaker.setBrends(sneakerB.getBrends());
		returnedSneaker.setTypes(sneakerT.getTypes());
		returnedSneaker.setSize(sneakerS.getSize());

		sneakers.add(returnedSneaker);

		return sneakers;
	}
	// @Override
	// public Sneaker findSneakerWithBrendAndModel(int id) {
	// SModel model = new SModel();
	// Brend brend = brendDao.brendWithModel(id);
	// brend.getModels().add(model);
	//
	//
	//
	// Sneaker sneaker = new Sneaker();
	//
	// sneaker.getBrends().add(brend);
	//
	// sneakerDao.save(sneaker);
	// return sneaker;
	// }
	//
	//

	@Override
	public Sneaker sneakerWithBrend(int id) {

		return sneakerDao.sneakerWithBrend(id);
	}

	@Override
	public Sneaker sneakerWithType(int id) {
		return sneakerDao.sneakerWithType(id);
	}

	@Override
	public Sneaker sneakerWithSize(int id) {
		return sneakerDao.sneakerWithSize(id);
	}

	@Override
	public Set<Sneaker> sneakerWithSizes() {
		return sneakerDao.sneakerWithSizes();
	}

	@Override
	public Page<Sneaker> findAll(Pageable pageable) {

		List<Sneaker> sneakers = sneakerDao.findAll(pageable).getContent();
//		List<Sneaker> returnedSneakers = new ArrayList<>();
//
//		for (Sneaker sneaker : sneakers) {
//			
//			for(Sneaker returnedSneaker : returnedSneakers ){
//				returnedSneaker.setId(sneaker.getId());
//				returnedSneaker.setPrice(sneaker.getPrice());
//				returnedSneaker.setQuantity(sneaker.getQuantity());
//				returnedSneaker.setSize(sneaker.getSize());
//			
//			
//			for(SModel models : sneaker.getModels()){
//				SModel model = new SModel(models.getId(),models.getName(),models.getPathImage());
//				returnedSneaker.getModels().add(model);
//			}
//			
//			for(Brend brends : sneaker.getBrends()){
//				Brend brend = new Brend(brends.getId(),brends.getName());
//				returnedSneaker.getBrends().add(brend);
//			}
//			for(SneakerType types : sneaker.getTypes()){
//				SneakerType type = new SneakerType(types.getId(),types.getName());
//				returnedSneaker.getTypes().add(type);
//			}
//			
//		}
//		}
		

		return sneakerDao.findAll(pageable);
	}

	@Override
	public Page<Sneaker> sneakerWithModelPages(Pageable pageable) {
		return sneakerDao.sneakerWithModelsPages(pageable);
	}

	@Override
	public Sneaker sneakerWithOrderSneaker(int id) {
		return sneakerDao.sneakerWithOrderSneaker(id);
	}

	@Override
	public Set<Sneaker> searchSneakerByModelName(String search) {
		
		Set<Sneaker> sneakers = sneakerDao.sneakerWithModels();
		Set<Sneaker> returnedSneakers = new HashSet<>();
		
		
		for(Sneaker returnedSneaker : sneakers){
			
			for(SModel model : returnedSneaker.getModels() ){
				
				if(model.getName().contains(search)){
//					
//					Sneaker sneaker1 = new Sneaker();
//					returnedSneaker.getModels().add(model);
//					sneaker1.setId(returnedSneaker.getId());
//					sneaker1.setPrice(returnedSneaker.getPrice());
//					sneaker1.setQuantity(returnedSneaker.getQuantity());
//					sneaker1.getModels().add(model);
					returnedSneakers.add(returnedSneaker);
				}
			}
			
		}
		
		
		return returnedSneakers;
	}

}

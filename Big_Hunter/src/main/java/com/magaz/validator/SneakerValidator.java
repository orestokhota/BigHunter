package com.magaz.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.magaz.entity.Sneaker;
import com.magaz.service.SneakerService;
import com.magaz.validator.Validator;
@Component
public class SneakerValidator implements Validator{

	@Autowired
	private SneakerService sneakerService;
	
	
	@Override
	public void validate(Object o) throws Exception {
		
		Sneaker sneaker = (Sneaker) o;
//		 if(sneaker.getPrice() == null){
//			throw new SneakerException(SneakerValidatorMessages.EMPTY_PRICE);
//		}else if(sneaker.getQuantity() == null){
//			throw new SneakerException(SneakerValidatorMessages.EMPTY_QUANTITY);
//		}
//		else if(sneaker.getBrends() == null){
//			throw new SneakerException(SneakerValidatorMessages.EMPTY_BREND);
//		}		else if(sneaker.getModels() == null){
//			throw new SneakerException(SneakerValidatorMessages.EMPTY_MODEL);
//		}
//		else if(sneaker.getTypes() == null){
//			throw new SneakerException(SneakerValidatorMessages.EMPTY_TYPE);
//		}
		
	}
	}
	

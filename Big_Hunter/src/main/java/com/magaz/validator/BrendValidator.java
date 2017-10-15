package com.magaz.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.magaz.entity.Brend;
import com.magaz.service.BrendService;
@Component
public class BrendValidator implements Validator {
	
	@Autowired
	private BrendService brendService;
	
	@Override
	public void validate(Object o) throws Exception {
		
		Brend brend =(Brend) o;
		
		if(brendService.findByName(brend.getName()) != null){
			throw new BrendException(BrendValidatorMessages.BREND_ALREADY_EXIST);
		} if(brend.getName().isEmpty()){
			throw new BrendException(BrendValidatorMessages.EMPTY_FIELD);
		}
		
		
		
	}

}

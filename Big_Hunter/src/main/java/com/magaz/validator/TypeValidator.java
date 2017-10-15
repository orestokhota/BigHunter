package com.magaz.validator;

import org.jsoup.select.Evaluator.IsEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.magaz.entity.SneakerType;
import com.magaz.service.SneakerTypeService;
import com.magaz.validator.Validator;

@Component
public class TypeValidator implements Validator {

	@Autowired
	private SneakerTypeService typeService;
	
	@Override
	public void validate(Object o) throws Exception {

		SneakerType sType = (SneakerType) o;
		
		if(sType.getName().isEmpty()){
			throw new SneakerTypeException(TypeValidatorMessages.EMPTY_FIELD);
		} else if(typeService.findByName(sType.getName()) != null){
			throw new SneakerTypeException(TypeValidatorMessages.TYPE_ALREADY_EXIST);
		}
		
		
	}

}

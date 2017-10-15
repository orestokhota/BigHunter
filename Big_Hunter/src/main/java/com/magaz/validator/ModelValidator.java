package com.magaz.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.magaz.entity.SModel;
import com.magaz.service.SModelService;
import com.magaz.validator.Validator;
@Component
public class ModelValidator implements Validator{
	
	@Autowired
	private SModelService sModelService;
	
	@Override
	public void validate(Object o) throws Exception {
		SModel model = (SModel) o;
		
		if(model.getName().isEmpty()){
			throw new ModelException(ModelValidatorMessages.EMTY_FIELD);
		}else if(sModelService.findByName(model.getName()) != null){
			throw new ModelException(ModelValidatorMessages.MODEL_ALREADY_EXIST);
	}
		//	else if(model.getPathImage().isEmpty()){
//			throw new ModelException(ModelValidatorMessages.EMPTY_IMAGE);
//		}
		
	}

}

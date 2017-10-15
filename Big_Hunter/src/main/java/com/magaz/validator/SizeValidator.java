package com.magaz.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.magaz.dao.SizeDAO;
import com.magaz.entity.Sizes;
import com.magaz.service.SizeService;

@Component
public class SizeValidator implements Validator {
	
	
	@Autowired
	private SizeService sizeService;

	@Override
	public void validate(Object o) throws Exception {

		Sizes size = (Sizes) o;

		if (size.getSize().isEmpty()) {
			throw new SizeException(SizeValidatorMessage.EMPTY_FIELD);

		}
		else if(sizeService.findBySize(size.getSize())!= null){
			throw new SizeException(SizeValidatorMessage.Size_Already_Exist);
		}
	}

}

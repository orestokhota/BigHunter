package com.magaz.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.magaz.dao.UserDAO;
import com.magaz.entity.User;
@Component
public class UserLoginValidator implements Validator {

		@Autowired 
		UserDAO userDao;
		
		 @Autowired
		 private BCryptPasswordEncoder encoder;
	
	
	@Override
	public void validate(Object o) throws Exception {

		 User user = (User) o;

	        if (user.getName().isEmpty()) {
	            throw new UserException(UserLoginValidatorMessage.EMPTY_USERNAME_FIELD);
	        } else if (userDao.findByName(user.getName()) == null) {
	            throw new UserException(UserLoginValidatorMessage.WRONG_USERNAME_OR_PASSWORD);
	        } else if (encoder.matches(user.getPassword(),
	                userDao.findByName(user.getName()).getPassword())){
	            throw new UserException(UserLoginValidatorMessage.WRONG_USERNAME_OR_PASSWORD);
	        }

		
		
		
	}

}

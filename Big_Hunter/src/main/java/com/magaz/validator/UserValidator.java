package com.magaz.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.magaz.entity.User;
import com.magaz.service.UserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public void validate(Object o) throws Exception {

		User user = (User) o;

		// String pass = user.getEmail();
		// int userPass = Integer.parseInt(user.getPassword());
		// int pass = 3;

		if (user.getName().isEmpty()) {
			throw new UserException(UserValidatorMessages.EMPTY_USERNAME_FIELD);

		} else if (userService.findByName(user.getName()) != null) {
			throw new UserException(UserValidatorMessages.USERNAME_ALREADY_EXIST);
		} else if (!user.getEmail().contains("@")) {
			throw new UserException(UserValidatorMessages.INCORECT_EMAIL);

		} else if (user.getEmail().isEmpty()) {
			throw new UserException(UserValidatorMessages.EMPTY_EMAIL_FIELD);
		} else if (userService.findByEmail(user.getEmail()) != null) {
			throw new UserException(UserValidatorMessages.EMAIL_ALREADY_EXIST);
		}

		else if (user.getPassword().isEmpty()) {
			throw new UserException(UserValidatorMessages.EMPTY_PASSWORD);

		} else if (user.getPassword().length() <= 4) {
			throw new UserException(UserValidatorMessages.PASSWORD_MUST_CONTAIN_4_SYMBOLS);

		}

	}

}

package com.magaz.controller;

import java.security.Principal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.magaz.entity.User;
import com.magaz.service.MailSenderService;
import com.magaz.service.SneakerService;
import com.magaz.service.UserService;
import com.magaz.validator.UserLoginValidatorMessage;
import com.magaz.validator.UserValidatorMessages;
import com.magaz.validator.Validator;

@Controller
public class UserController {
	@Autowired
	private MailSenderService mailSenderService;
	@Autowired
	private SneakerService snService;

	@Autowired
	private UserService userService;
	
	
	@Autowired
	@Qualifier("userLoginValidator")
	private Validator validator;

	@GetMapping("/signUp")
	public String registration(Model model) {
		model.addAttribute("users", userService.findAll());

		return "views-user-signUp";
	}

	@PostMapping("/signUp")
	public String registration(@RequestParam String name, String password, String email, Model model) {
		
		String uuid = UUID.randomUUID().toString();
		
		User user = new User(name,email,password);
		
		user.setUuid(uuid);
		
		try {
			userService.save(user);
		} catch (Exception e) {
			if (e.getMessage().equals(UserValidatorMessages.EMPTY_USERNAME_FIELD)
					|| e.getMessage().equals(UserValidatorMessages.USERNAME_ALREADY_EXIST)) {

				model.addAttribute("usernameException", e.getMessage());
			} else if (e.getMessage().equals(UserValidatorMessages.INCORECT_EMAIL)
					|| e.getMessage().equals(UserValidatorMessages.EMPTY_EMAIL_FIELD)) {

				model.addAttribute("emailException", e.getMessage());

			} else if(e.getMessage().equals(UserValidatorMessages.EMAIL_ALREADY_EXIST)){
				model.addAttribute("emailException", e.getMessage());
			}
			else if (e.getMessage().equals(UserValidatorMessages.EMPTY_PASSWORD)
					|| e.getMessage().equals(UserValidatorMessages.PASSWORD_MUST_CONTAIN_4_SYMBOLS)) {
				model.addAttribute("passwordException", e.getMessage());
			}

			return "views-user-signUp";
		}
		 String theme = "thank's for registration";
	        String mailBody =
	                "You need to confirm Your registration by clicking on the URL       http://localhost:11141/confirm/" + uuid;

	        mailSenderService.sendEmail(theme, mailBody, user.getEmail());

		return "redirect:/signUp";
	}

	@GetMapping("/deleteUser/{id}")
	public String delete(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/signUp";

	}
	@PostMapping("/logout")
		public String logout(){
		return "/";
	}
	@GetMapping("/profile")
		public String profile(Principal principal,Model model){
		model.addAttribute("userBasket", userService.findUserWithSneakerWithAllParam(Integer.parseInt(principal.getName())));
		return "views-user-profile";
	}
//	@GetMapping("/sneakers/{id}")
//	
//	public String sneakers(Model model,@PathVariable int id){
//		
//		model.addAttribute("sneakers", snService.findSneakerWithBrendAndModel(id));
//		
//		return"views-user-sneakersAll";
//	}
	
	 @GetMapping("/confirm/{uuid}")
	    public String confirm(@PathVariable String uuid) {

	        User user = userService.findUserByUUID(uuid);
	        user.setEnable(true);

	        userService.update(user);

	        return "redirect:/";
	    }
	 
	 @GetMapping("/history")
	 public String history(Principal principal,Model model){
		 
		 model.addAttribute("user", userService.findUserWithOrder(Integer.parseInt(principal.getName())));
		 
		 return"views-user-history";
	 }
	 
	 @PostMapping("/loginError")
	 public String loginError(@RequestParam String username,@RequestParam String password,Model model){
		 
		 try {
			 validator.validate(new User(username,password));
			
		} catch (Exception e) {

			 if(e.getMessage().equals(UserLoginValidatorMessage.EMPTY_USERNAME_FIELD)||
	                    e.getMessage().equals(UserLoginValidatorMessage.EMPTY_PASSWORD_FIELD)||
	                    e.getMessage().equals(UserLoginValidatorMessage.WRONG_USERNAME_OR_PASSWORD)){
	                model.addAttribute("exception", e.getMessage());
	            }
			 model.addAttribute("user", new User());
		}
		 
		 
		 
		 return"views-user-signUp";
	 }

}

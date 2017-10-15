package com.magaz.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.magaz.service.OrdersService;
import com.magaz.service.UserService;

@Controller
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addToCart/{id}")
		public String addToCart(Principal principal,@PathVariable int id,@RequestParam int oQua){
		
		
		System.out.println("1111");
		ordersService.addToCart(principal, id,oQua);
		
			return "redirect:/sneakersAll";
			
		}
	
	@GetMapping("/delete/{userId}/{sneakerId}")
	public String deleteFromBasket(@PathVariable int userId,@PathVariable int sneakerId){
		
		ordersService.deleteFromBasket(userId, sneakerId);
		
		
		return"redirect:/profile";
	}
	
	@PostMapping("/buy/{userId}")
	public String buy(@PathVariable int userId){
		
		ordersService.buy(userId);
		
		return"redirect:/";
		
	}
	

}

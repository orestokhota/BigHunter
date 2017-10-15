package com.magaz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.magaz.service.SneakerService;

@Controller
public class IndexController {
	
	@Autowired
	private SneakerService snService;
	
	@GetMapping("/")
	public String index(Model model){
		return "views-base-index";
	}
	@PostMapping("/")
	public String indexAfterLogin(){
		return"views-base-index";
	}
//	@GetMapping("/addToMain/{id}")
//	public String add(@PathVariable int id,Model model){
//		model.addAttribute(	"sneakers",snService.sneakerWithAll(id));
//		return "views-base-index";
//	}
//	
	
	@GetMapping("/login")
	public String login(Model model){
		return "views-base-index";
	}
}

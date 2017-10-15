package com.magaz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.magaz.entity.Sizes;
import com.magaz.service.SizeService;
import com.magaz.validator.SizeValidatorMessage;

@Controller
public class SizeController {

	@Autowired
	private SizeService sizeService;

	@GetMapping("/size")
	public String sizes(Model model) {
		model.addAttribute("sizes", sizeService.findAll());
		return "views-admin-size";
	}

	@PostMapping("/size")
	public String sizes(@RequestParam String size, Model model) {
		try {
			sizeService.save(new Sizes(size));
		} catch (Exception e) {
			if (e.getMessage().equals(SizeValidatorMessage.EMPTY_FIELD)||
					e.getMessage().equals(SizeValidatorMessage.Size_Already_Exist)) {
				model.addAttribute("sizeEx", e.getMessage());
			}
			return "views-admin-size";

		}
		return "redirect:/size";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		sizeService.delete(id);
		
		return"redirect:/size";
	}
	
	@GetMapping("/updateSize/{size_id}")
	public String update(Model model,@PathVariable int size_id){
		
		model.addAttribute("size", sizeService.findOne(size_id));
		return "views-adminUpdate-sizeUpdate";
	}
	
	@PostMapping("/updateSize/{id}")
	public String update(@PathVariable int id,@RequestParam String size,Model model){
		
		try{
		
		Sizes size1 = sizeService.findOne(id);
		
		size1.setSize(size);
		
		sizeService.update(size1);
		}catch (Exception e) {
			if (e.getMessage().equals(SizeValidatorMessage.EMPTY_FIELD)||
					e.getMessage().equals(SizeValidatorMessage.Size_Already_Exist)) {
				model.addAttribute("sizeEx", e.getMessage());
			}
			return "views-adminUpdate-sizeUpdate";
		
		}
		
		
		
		return"redirect:/size";
		
	}

}

package com.magaz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.magaz.entity.Brend;
import com.magaz.service.BrendService;
import com.magaz.service.SModelService;
import com.magaz.validator.BrendValidatorMessages;




@Controller
public class BrendController {

	@Autowired
	private BrendService brendService;
//	@Autowired
//	private SModelService modelService;

	@GetMapping("/brend")
	public String brend(Model model) {
		model.addAttribute("brends", brendService.findAll());
		model.addAttribute("brend", new Brend());

		return "views-admin-brend";

	}

	@PostMapping("/brend")
	public String brend(@RequestParam String brendName,Model model) throws Exception {
		try{
			brendService.save(new Brend(brendName));
			
		} catch (Exception e) {
			if (e.getMessage().equals(BrendValidatorMessages.BREND_ALREADY_EXIST)
					|| e.getMessage().equals(BrendValidatorMessages.EMPTY_FIELD)) {

				model.addAttribute("brendException", e.getMessage());
			}

			return "views-admin-brend";
		}
		return "redirect:/brend";

	}

	@GetMapping("/deleteBrend/{id}")
	public String delete(@PathVariable int id) {
		brendService.delete(id);
		return "redirect:/brend";
	}

	@GetMapping("/updateBrend/{brend_id}")
	public String updateBrend(@PathVariable int brend_id, Model model) {

		Brend brend = brendService.findOne(brend_id);
		
		model.addAttribute("brend", brend);
		
		System.out.println(brend);
		

		return "views-adminUpdate-updateBrend";

	}

	@PostMapping("/safeUpdatesBrend/{id}")
	public String updateBrend(@RequestParam String brendName, @PathVariable int id,Model model) throws Exception {
		try{
		System.out.println(id);
		Brend brend = brendService.findOne(id);
		
		System.out.println(brend);
		brend.setName(brendName);
		brendService.update(brend);
		}catch (Exception e) {
			if (e.getMessage().equals(BrendValidatorMessages.BREND_ALREADY_EXIST)
					|| e.getMessage().equals(BrendValidatorMessages.EMPTY_FIELD)) {

				model.addAttribute("brendException", e.getMessage());
			} 
			return "views-admin-brend";
		}
		return "redirect:/brend";
	}

}

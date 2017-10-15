package com.magaz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.magaz.entity.SneakerType;
import com.magaz.service.SneakerTypeService;
import com.magaz.validator.TypeValidatorMessages;

@Controller
public class SneakerTypeController {

	@Autowired
	private SneakerTypeService sneakerTypeService;

	@GetMapping("/type")
	public String type(Model model) {
		model.addAttribute("types", sneakerTypeService.findAll());
		model.addAttribute("type1", new SneakerType());
		return "views-admin-type";

	}

	@PostMapping("/type")
	public String type(@RequestParam String typeName, Model model) {
		try {
			sneakerTypeService.save(new SneakerType(typeName));
		} catch (Exception e) {
			if (e.getMessage().equals(TypeValidatorMessages.EMPTY_FIELD)
					|| e.getMessage().equals(TypeValidatorMessages.TYPE_ALREADY_EXIST)) {
				model.addAttribute("typeException", e.getMessage());
			}
			return "views-admin-type";
		}
		return "redirect:/type";
	}

	// @PostMapping("/type")
	// public String type(@ModelAttribute SneakerType snType,Model model){
	// try{
	// sneakerTypeService.save(snType);
	// }catch (Exception e) {
	// if(e.getMessage().equals(TypeValidatorMessages.EMPTY_FIELD)||
	// e.getMessage().equals(TypeValidatorMessages.TYPE_ALREADY_EXIST)){
	// model.addAttribute("typeException", e.getMessage());
	// }
	// return "type";
	// }
	// return "redirect:/type";

	// }

	@GetMapping("/deleteType/{id}")
	public String deleteModel(@PathVariable int id) {
		sneakerTypeService.delete(id);
		return "redirect:/type";
	}

	@GetMapping("/updateType/{id}")
	public String updateType(@PathVariable int id, Model model) {
		SneakerType sneakerType = sneakerTypeService.findOne(id);
		model.addAttribute("currentType", sneakerType);
		return "views-adminUpdate-updateType";

	}

	@PostMapping("/updateType/{id}")
	public String updateType(@RequestParam String name, @PathVariable int id, Model model) {
try{
		SneakerType sneakerType = sneakerTypeService.findOne(id);

		sneakerType.setName(name);

		sneakerTypeService.update(sneakerType);
		
}catch (Exception e) {

	if (e.getMessage().equals(TypeValidatorMessages.EMPTY_FIELD)
			|| e.getMessage().equals(TypeValidatorMessages.TYPE_ALREADY_EXIST)) {
		model.addAttribute("typeException", e.getMessage());
	}
	return "views-adminUpdate-updateType";

}
		
		return "redirect:/type";

	}

}

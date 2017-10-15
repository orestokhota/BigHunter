package com.magaz.controller;

import java.util.List;

import org.hibernate.proxy.map.MapProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.magaz.entity.SModel;
import com.magaz.service.SModelService;
import com.magaz.service.SneakerTypeService;
import com.magaz.validator.ModelValidatorMessages;


@Controller
public class SModelController {
	
	
	@Autowired
	private SModelService smodelService;
	
	
	@GetMapping("/model")
	public String model(Model model,@PageableDefault Pageable pageable){
		model.addAttribute("models", smodelService.findAll(pageable));
		return"views-admin-model";
		
	}
	
	
	
//	@PostMapping("/model")
//	public String model(@ModelAttribute SModel sModel,Model model){
//		try{
//		smodelService.save(sModel);
//		}catch (Exception e) {
//			if(e.getMessage().equals(ModelValidatorMessages.EMTY_FIELD)||
//					e.getMessage().equals(ModelValidatorMessages.MODEL_ALREADY_EXIST)){
//				model.addAttribute("modelException", e.getMessage());
//			}
//
//		return"model";
//		
//		}
//		return "redirect:/model";
//	}
	
	@PostMapping("/model")
	public String model(@RequestParam String modelName,Model model,@RequestParam MultipartFile image) throws Exception {
		try{
		smodelService.save(new SModel(modelName),image);
	}catch (Exception e) {
			if(e.getMessage().equals(ModelValidatorMessages.EMTY_FIELD)||
					e.getMessage().equals(ModelValidatorMessages.MODEL_ALREADY_EXIST)||
					e.getMessage().equals(ModelValidatorMessages.EMPTY_IMAGE)){
				model.addAttribute("modelException", e.getMessage());
			}

		return"views-admin-model";
			
		}
		
		return "redirect:/model";
	}
	
	
	@GetMapping("/deleteModel/{id}")
	public String delete(@PathVariable int id){
		smodelService.delete(id);
		return"redirect:/model";
	}
	
	
	@GetMapping("/updateModel/{id}")
	public String updateModel(@PathVariable int id,Model model){
		SModel sModel = smodelService.findOne(id);
		model.addAttribute("currentModel", sModel);
		return "views-adminUpdate-updateModel";
		
		
	}
	@PostMapping("/updateModel/{id}")
	public String updateModel(@RequestParam String name,@PathVariable int id,@RequestParam MultipartFile image,Model model) throws Exception{
		
		try{
		
		SModel sModel = new SModel(name);
		sModel.setId(id);
		smodelService.update(sModel,image);
		}catch (Exception e) {
			if(e.getMessage().equals(ModelValidatorMessages.EMTY_FIELD)||
					e.getMessage().equals(ModelValidatorMessages.MODEL_ALREADY_EXIST)||
					e.getMessage().equals(ModelValidatorMessages.EMPTY_IMAGE)){
				model.addAttribute("modelException", e.getMessage());
			}

		return"views-adminUpdate-updateModel";
			
		}
		
		
		return"redirect:/model";
	}
	
//	@PostMapping("/searchModels")
//	public @ResponseBody List<SModel> searchModels(@RequestBody String search,Model model){
//		model.addAttribute("search", smodelService.searchModels(search));
//		
//		return "views-admin-model";
//	}
	
	

}

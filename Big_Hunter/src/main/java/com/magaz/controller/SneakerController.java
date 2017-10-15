package com.magaz.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.magaz.dto.DtoUtilMapper;
import com.magaz.dto.SneakerDto;
import com.magaz.editors.BrendEditor;
import com.magaz.editors.ModelEditor;
import com.magaz.editors.TypeEditor;
import com.magaz.entity.Brend;
import com.magaz.entity.SModel;
import com.magaz.entity.Sneaker;
import com.magaz.entity.SneakerType;
import com.magaz.service.BrendService;
import com.magaz.service.SModelService;
import com.magaz.service.SizeService;
import com.magaz.service.SneakerService;
import com.magaz.service.SneakerTypeService;
import com.magaz.validator.SneakerValidatorMessages;

@Controller
public class SneakerController {

	@Autowired
	private SneakerService snService;

	@Autowired
	private SModelService sModelService;

	@Autowired
	private BrendService brendService;

	@Autowired
	private SneakerTypeService sTypeService;

	@Autowired
	private SizeService sizeService;

	// @InitBinder
	// public void init(WebDataBinder binder){
	// binder.registerCustomEditor(Brend.class, new BrendEditor());
	// binder.registerCustomEditor(SModel.class, new ModelEditor());
	// binder.registerCustomEditor(SneakerType.class, new TypeEditor());
	// }

	@GetMapping("/sneaker")
	public String sneakers(Model model) {
		model.addAttribute("sneakers", snService.sneakerWithModels());
		model.addAttribute("sizes", sizeService.findAll());
		model.addAttribute("brends", brendService.findAll());
		model.addAttribute("models", sModelService.findAll());
		model.addAttribute("types", sTypeService.findAll());
		model.addAttribute("sneaker", new Sneaker());
		return "views-admin-sneaker";
	}

	@PostMapping("/sneaker")
	public String sneakers(@RequestParam String price, @RequestParam String quantity, @RequestParam String brend,
			@RequestParam String type, @RequestParam String size, @RequestParam String model, Model model1)
			throws Exception {

		if (price.isEmpty()) {
			model1.addAttribute("priceExc", "error price");
			return "views-admin-sneaker";
		} else if (quantity.isEmpty()) {
			model1.addAttribute("quantityExc", "error quantity");
			return "views-admin-sneaker";
		} else if (size.equals("none")) {
			model1.addAttribute("sizeExc", "error size");
			return "views-admin-sneaker";
		} else if (brend.equals("none")) {
			model1.addAttribute("brendExc", "error brend");
			return "views-admin-sneaker";
		} else if (type.equals("none")) {
			model1.addAttribute("typeExc", "error type");
			return "views-admin-sneaker";
		} else if (model.equals("none")) {
			model1.addAttribute("modelExc", "error model");
			return "views-admin-sneaker";
		}

		snService.save(new Sneaker(price, Integer.parseInt(quantity)), Integer.parseInt(brend), Integer.parseInt(model),
				Integer.parseInt(type), Integer.parseInt(size));

		return "redirect:/sneaker";

	}

	@GetMapping("/deleteSneaker/{id}")
	public String delete(@PathVariable int id) {
		snService.delete(id);
		return "redirect:/sneaker";
	}

	@GetMapping("/show/{id}")
	public String showSneaker(@PathVariable int id, Model model) {

		Sneaker sneaker = snService.sneakerWithAll(id);

		model.addAttribute("sneaker", sneaker);
		return "views-admin-showSneaker";
	}

	@GetMapping("/sneakersAll")
	public String sneakersAll(Model model, @PageableDefault Pageable pageable) {
	model.addAttribute("sneaker", snService.sneakerWithModelPages(pageable));
		System.out.println(snService.findAll(pageable).getContent());
		//model.addAttribute("sneaker", snService.findAll(pageable));
		model.addAttribute("sneakerB", snService.sneakerWithBrends());
		model.addAttribute("sneakerM", snService.sneakerWithModels());
		model.addAttribute("sneakerS", snService.sneakerWithSizes());
		model.addAttribute("sneakerT", snService.sneakerWithTypes());
		return "views-admin-sneakersAll";
	}

	@GetMapping("/updateSneaker/{sneakerId}")
	public String updateSneaker(Model model, @PathVariable int sneakerId) {
		model.addAttribute("sneaker", snService.sneakerWithBrend(sneakerId));
		model.addAttribute("sneakerB", brendService.findAll());
		model.addAttribute("sneakerT", sTypeService.findAll());
		model.addAttribute("sneakerM", sModelService.findAll());
		model.addAttribute("sneakerS", sizeService.findAll());
		return "views-adminUpdate-updateSneaker";
	}

	@PostMapping("/updateSneaker/{id}")
	public String updateSneaker(@PathVariable int id, @RequestParam String price, @RequestParam String quantity,
			@RequestParam String brend, @RequestParam String model, @RequestParam String type,
			@RequestParam String size, Model model1) throws Exception {
		if (price.isEmpty()) {
			model1.addAttribute("priceExc", "error price");
			return "views-admin-sneaker";
		} else if (quantity.isEmpty()) {
			model1.addAttribute("quantityExc", "error quantity");
			return "views-admin-sneaker";
		} else if (size.equals("none")) {
			model1.addAttribute("sizeExc", "error size");
			return "views-admin-sneaker";
		} else if (brend.equals("none")) {
			model1.addAttribute("brendExc", "error brend");
			return "views-admin-sneaker";
		} else if (type.equals("none")) {
			model1.addAttribute("typeExc", "error type");
			return "views-admin-sneaker";
		} else if (model.equals("none")) {
			model1.addAttribute("modelExc", "error model");
			return "views-admin-sneaker";
		}

		Sneaker sneaker = snService.sneakerWithAll(id);

		Sneaker returnedSneaker = new Sneaker(price, Integer.parseInt(quantity));

		returnedSneaker.setId(sneaker.getId());

		snService.update(returnedSneaker,Integer.parseInt(brend), Integer.parseInt(model),
				Integer.parseInt(type), Integer.parseInt(size));

		return "redirect:/sneaker";

	}
	
	@GetMapping("/search/{searchParam}")
	public @ResponseBody Set<SneakerDto> search(@PathVariable String searchParam){
		System.out.println(searchParam);
		System.out.println(snService.searchSneakerByModelName(searchParam));
		return DtoUtilMapper.sneakerToSneakerDtos(snService.searchSneakerByModelName(searchParam));
//		return DtoUtilMapper.sneakerToSneakerDtos(snService.searchSneakerByModelName(search));
		
	}

}

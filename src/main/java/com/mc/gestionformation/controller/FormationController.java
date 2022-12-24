package com.mc.gestionformation.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

import com.mc.gestionformation.business.IFormationService;
import com.mc.gestionformation.dto.FormationDTO;
import com.mc.gestionformation.model.Formation;

@Controller
@RequestScope
@RequestMapping("/formation")
public class FormationController {

	@Autowired
	UserBucket panier;

	Logger log = LoggerFactory.getLogger(getClass());

	private Formation formation;

	@Autowired
	IFormationService formationService;

	@RequestMapping(value = { "/showEditForm", "/showEditForm/{id}" })
	String showForm(@PathVariable Optional<Long> id, Model model) {

		log.info(String.format("Le code de la formation est [%s]", id.orElse(0L)));
		if (id.isPresent()) {
			formation = formationService.findById(new FormationDTO(new Formation(id.get()))).getEntity();
			log.info(formation.toString());
			model.addAttribute("formation", formation);

		} else {
			model.addAttribute("formation", new Formation());
		}
		return "/formation/editFormation";

	}

	@PostMapping("/persist")
	// @ModelAttribute("formation") injection du model attribute par son nom
	String create(@ModelAttribute("formation") @Valid Formation formation, BindingResult result) {

		if (result.hasErrors()) {
			log.info(result.toString());
			return "/formation/editFormation";
		}
		if (formation.getId() != null) {
			log.info("update object formation : " + formation.toString());
			formationService.update(new FormationDTO(formation));
		} else {
			log.info("create object formation : " + formation.toString());
			formationService.create(new FormationDTO(formation));
		}
		return "redirect:/formation/list";
	}

	@GetMapping("/list") // curl -x GET http://localhost:8181/gestionFormation/formation/list
	String listFormation(Model model) {
		FormationDTO dto = formationService.findAll(new FormationDTO());
		List<Formation> allFormations = dto != null ? dto.getListEntity() : List.of();
		model.addAttribute("formations", allFormations);
		return "/formation/listFormation";
	}

	@GetMapping("/list2") // curl -x GET http://localhost:8181/gestionFormation/formation/list
	String listFormation(ModelMap model) {
		FormationDTO dto = formationService.findAll(new FormationDTO());
		List<Formation> allFormations = dto != null ? dto.getListEntity() : List.of();
		model.addAttribute("formations", allFormations);
		return "/formation/listFormation";
	}

	@GetMapping("/list3") // curl -x GET http://localhost:8181/gestionFormation/formation/list
	String listFormation(Map model) {
		FormationDTO dto = formationService.findAll(new FormationDTO());
		List<Formation> allFormations = dto != null ? dto.getListEntity() : List.of();
		model.put("formations", allFormations);
		return "/formation/listFormation";
	}

	@RequestMapping("/delete/{id}")
	String deleteFormation(@PathVariable Long id, Model model) {
		Formation formationToDelete = new Formation(id);
		formationService.delete(new FormationDTO(formationToDelete));
		return "redirect:/formation/list";
	}

	@RequestMapping("/show/{code}")
	String showFormation(@PathVariable String code, Model model) {
		return "formation/showFormation";
	}
	
	@RequestMapping("/show?code={code}")
	String showFormationWithParam(@RequestParam String code, Model model) {
		return "formation/showFormation";
	}

}

package br.com.ilia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ilia.model.WorkingHour;
import br.com.ilia.service.WorkingHourService;

@Controller
@RequestMapping("/working-hour")
public class WorkingHourController {

	@Autowired
	private WorkingHourService service;
	
	@GetMapping
	public ModelAndView index(WorkingHour workingHour) {
		ModelAndView modelAndView = new ModelAndView("working-hour");
		return modelAndView;
	}

	@GetMapping("/form")
	public ModelAndView form(WorkingHour workingHour) {
		ModelAndView modelAndView = new ModelAndView("workingHours");
		List<WorkingHour> workingHours = service.findAll();
		modelAndView.addObject("workingHours", workingHours);
		return modelAndView;
	}
	
	@PostMapping
	public String save(@Valid WorkingHour workingHour, BindingResult result) {
		if(result.hasErrors()) { //If has errors
			return "working-hour"; //Return to the same page
		}

		if(service.create(workingHour)) {
			return "redirect:working-hour/form";			
		}else {
			return "redirect:working-hour";//redirect - Prevent that fields are filled
		}
	}
}

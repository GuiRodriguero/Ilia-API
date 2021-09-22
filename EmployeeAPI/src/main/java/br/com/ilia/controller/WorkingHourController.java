package br.com.ilia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;

import br.com.ilia.model.WorkingHour;
import br.com.ilia.repository.WorkingHourRepository;
import br.com.ilia.service.WorkingHourService;

@Controller
@RequestMapping("/working-hour")
public class WorkingHourController {

	@Autowired
	private WorkingHourService service;
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("working-hour");
		return modelAndView;
	}
	
	@PostMapping
	public String save(@Valid WorkingHour workingHour, BindingResult result) {
		if(result.hasErrors()) {
			return "working-hour";
		}
		System.out.println(workingHour.getType());
		System.out.println(workingHour.getDateRegister());
		service.create(workingHour);
		return "working-hour";
	}
}

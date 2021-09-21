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

@Controller
@RequestMapping("/working-hour")
public class WorkingHourController {

	@Autowired
	private WorkingHourRepository repository;
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("working-hour");
		return modelAndView;
	}
	
	@PostMapping
	public String save(@Valid WorkingHour workingHour, BindingResult result) {
		System.out.println(workingHour.getDateRegister());
		System.out.println(workingHour.getStartHour());
		System.out.println(workingHour.getStartMinute());
		System.out.println(workingHour.getEndMinute());
		System.out.println(workingHour.getEndHour());
		
		repository.save(workingHour);
		return "working-hour";
	}
}

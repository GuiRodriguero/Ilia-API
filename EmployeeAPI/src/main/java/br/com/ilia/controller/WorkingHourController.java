package br.com.ilia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
}

package br.com.ilia.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ilia.model.WorkingHour;
import br.com.ilia.service.WorkingHourService;

@RestController
@RequestMapping("/api/working-hour")
public class ApiWorkingHourController {

	@Autowired
	private WorkingHourService service;
	
	@GetMapping
	public List<WorkingHour> findAll(){
		return service.findAll();
	}
	
	@PostMapping
	public String create(@RequestBody WorkingHour workingHour) {
		return service.create(workingHour);
	}

	@GetMapping("/{date}")
	public List<WorkingHour> findbyDate(@PathVariable("date") String date) {
		return service.findByDate(date);
	}
}

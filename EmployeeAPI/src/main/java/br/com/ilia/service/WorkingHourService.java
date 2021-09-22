package br.com.ilia.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ilia.exception.ResourceNotFoundException;
import br.com.ilia.model.WorkingHour;
import br.com.ilia.repository.WorkingHourRepository;

@Service
public class WorkingHourService {

	@Autowired
	WorkingHourRepository repository;
	
	public String create(WorkingHour workingHour) {
		//Replacing / to - for API
		workingHour.setDateRegister(workingHour.getDateRegister().replaceAll("/", "-"));
		
		if(workingHour.getStartHour() <= workingHour.getEndHour()) {//Start Hour <= End Hour
			if(workingHour.getStartMinute() < workingHour.getEndMinute()) {//Start Minute <= End Minute				
				repository.save(workingHour);
				return "Working Hour Added!";
			}else {
				return "Error";
			}
		}else {
			return "Error";
		}
		
	}
	
	public List<WorkingHour> findAll(){
		return repository.findAll();
	}
	
	public WorkingHour findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}

	public List<WorkingHour> findByDate(String date) {
		return repository.findByDateRegister(date);
	}
	
}

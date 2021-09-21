package br.com.ilia.service;

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
	
	public WorkingHour create(WorkingHour workingHour) {
		return repository.save(workingHour);
	}
	
	public List<WorkingHour> findAll(){
		return repository.findAll();
	}
	
	public WorkingHour findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}
	

}

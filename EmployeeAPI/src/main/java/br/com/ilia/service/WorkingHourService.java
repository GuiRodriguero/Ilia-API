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

	public String create(WorkingHour workingHour) {
		// Replacing / to - for API search
		workingHour.setDateRegister(workingHour.getDateRegister().replaceAll("/", "-"));

		// Get All Working Hours from the inserted day
		List<WorkingHour> workingHours = repository.findByDateRegister(workingHour.getDateRegister());
		
		if(workingHours.size() <= 3) {
			// Check if Star is Greater than End
			if (workingHour.getStartHour() <= workingHour.getEndHour()) {// Start Hour <= End Hour
				if (workingHour.getStartMinute() < workingHour.getEndMinute()) {// Start Minute <= End Minute
					repository.save(workingHour);
					return "Working Hour Added!";
				} else {
					return "Start Hour/Minute > EndHour/Minute";
				}
			} else {
				return "Start Hour/Minute > EndHour/Minute";
			}			
		}else {
			return "Working Hours limit for the day reached";
		}
		
	}

	public List<WorkingHour> findAll() {
		return repository.findAll();
	}

	public WorkingHour findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}

	public List<WorkingHour> findByDate(String date) {
		return repository.findByDateRegister(date);
	}

}

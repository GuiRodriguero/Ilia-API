package br.com.ilia.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

	public Boolean create(WorkingHour workingHour) {
		
		//Parsing String to Calendar to check Day of The Week
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			cal.setTime(sdf.parse(workingHour.getDateRegister()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		//If not Sunday and Saturday
		if(cal.get(Calendar.DAY_OF_WEEK) != 1 && cal.get(Calendar.DAY_OF_WEEK) != 7) {
			// Replacing / to - for API search
			workingHour.setDateRegister(workingHour.getDateRegister().replaceAll("/", "-"));

			// Get All Working Hours from the inserted day
			List<WorkingHour> workingHours = repository.findByDateRegister(workingHour.getDateRegister());
			
			//Working Hours cannot be greater than 4/day
			if(workingHours.size() <= 3) {
				// Check if Star is Greater than End
				if (workingHour.getStartHour() <= workingHour.getEndHour()) {// Start Hour <= End Hour
					if (workingHour.getStartMinute() < workingHour.getEndMinute()) {// Start Minute <= End Minute
						repository.save(workingHour);
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}			
			}else {
				return false;
			}
		}else {
			return false;
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

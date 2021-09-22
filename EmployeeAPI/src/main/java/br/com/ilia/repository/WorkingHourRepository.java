package br.com.ilia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ilia.model.WorkingHour;

public interface WorkingHourRepository extends JpaRepository<WorkingHour, Long>{
	
	List<WorkingHour> findByDateRegister(String dateRegister);

}

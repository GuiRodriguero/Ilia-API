package br.com.ilia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ilia.model.WorkingHour;

public interface WorkingHourRepository extends JpaRepository<WorkingHour, Long>{

}

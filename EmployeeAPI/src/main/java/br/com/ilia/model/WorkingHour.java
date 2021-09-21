package br.com.ilia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;

@Data
@Entity(name = "TB_WORKING_HOUR")
@SequenceGenerator(name = "workHour", sequenceName = "SQ_TB_WORK_HOUR", allocationSize = 1)
public class WorkingHour {

	@Id @GeneratedValue(generator = "workHour", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Min(value = 0)
	@Max(value = 23)
	private Integer starHour;

	@Min(value = 0)
	@Max(value = 60)
	private Integer starMinute;

	@Min(value = 0)
	@Max(value = 23)
	private Integer endHour;

	@Min(value = 0)
	@Max(value = 60)
	private Integer endMinute;

}

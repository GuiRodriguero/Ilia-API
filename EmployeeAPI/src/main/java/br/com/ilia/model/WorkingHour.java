package br.com.ilia.model;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity(name = "TB_WORKING_HOUR")
@SequenceGenerator(name = "workHour", sequenceName = "SQ_TB_WORK_HOUR", allocationSize = 1)
public class WorkingHour {

	@Id @GeneratedValue(generator = "workHour", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotBlank(message = "Date can\''t be null")
	private String dateRegister;

	@Enumerated(EnumType.STRING)
	@NotNull
	private WorkingHourType type;
	
	@Min(value = 0)
	@Max(value = 23)
	@NotNull
	private Integer startHour;

	@Min(value = 0)
	@Max(value = 60)
	@NotNull
	private Integer startMinute;

	@Min(value = 0)
	@Max(value = 23)
	@NotNull
	private Integer endHour;

	@Min(value = 0)
	@Max(value = 60)
	@NotNull
	private Integer endMinute;

}

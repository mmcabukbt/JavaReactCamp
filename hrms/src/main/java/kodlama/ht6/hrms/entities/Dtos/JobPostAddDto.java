package kodlama.ht6.hrms.entities.Dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class JobPostAddDto {	
	private long userId;
	private String description;
	private double minSalary;
	private double maxSalary;
	private Date closingDate;
	private int openPositions;
	private boolean active;
	private int jobId;
	private int cityId;
}
package kodlama.ht6.hrms.entities.Dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class JobPostAddDto {	
	
	private Long userId;
	private String description;
	private Double minSalary;
	private Double maxSalary;
	private Date closingDate;
	private Short openPositions;
	private boolean active;
	private Short jobId;
	private Short cityId;
}
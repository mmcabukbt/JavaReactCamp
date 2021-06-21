package kodlama.ht6.hrms.core.entities.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public @Data class StaffProfileDto extends PersonRegisterDto {
	
	@JsonIgnore
	private int jobId;
	
//	@JsonIgnore
	private double salary;
}
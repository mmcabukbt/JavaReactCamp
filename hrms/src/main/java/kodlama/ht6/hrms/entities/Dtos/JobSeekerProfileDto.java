package kodlama.ht6.hrms.entities.Dtos;

import kodlama.ht6.hrms.core.entities.DTOs.PersonRegisterDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public @Data class JobSeekerProfileDto extends PersonRegisterDto{
	
	private Boolean jobseekStatus;
}
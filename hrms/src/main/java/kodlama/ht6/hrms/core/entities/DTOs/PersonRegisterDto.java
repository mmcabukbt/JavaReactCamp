package kodlama.ht6.hrms.core.entities.DTOs;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public @Data class PersonRegisterDto extends UserRegisterDto {
	
	private String tckNo;
	private String firstName;
	private String lastName;
	private Short yearOfBirth;
} 
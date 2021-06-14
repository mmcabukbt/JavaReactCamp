package kodlama.ht6.hrms.core.entities.DTOs;

import kodlama.ht6.hrms.core.entities.abstracts.Dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class UserLoginDto implements Dto{
	
	private String email;
	private String password;
}

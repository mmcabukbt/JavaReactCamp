package kodlama.ht6.hrms.core.entities.DTOs;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public @Data class CorporateRegisterDto extends UserRegisterDto{

	private String companyName;
	private String website;
	private String phone;
}
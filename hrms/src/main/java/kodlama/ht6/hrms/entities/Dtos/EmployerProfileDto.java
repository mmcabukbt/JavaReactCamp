package kodlama.ht6.hrms.entities.Dtos;

import kodlama.ht6.hrms.core.entities.DTOs.CorporateRegisterDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public @Data class EmployerProfileDto extends CorporateRegisterDto{

	private Short sectorId;
}
package kodlama.ht6.hrms.entities.Dtos.jsResumeBase;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class JsEducationDto {
	
	@NotNull	@NotBlank
	private String schoolName;
	private String branch;
	
	@Min(1950)	@Max(2025)
	private Short startingYear;
	private Short finishingYear;
}
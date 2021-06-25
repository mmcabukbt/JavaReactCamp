package kodlama.ht6.hrms.entities.Dtos;

import java.util.List;

import javax.validation.Valid;

import kodlama.ht6.hrms.entities.Dtos.jsResumeBase.JsEducationDto;
import kodlama.ht6.hrms.entities.Dtos.jsResumeBase.JsExperienceDto;
import kodlama.ht6.hrms.entities.Dtos.jsResumeBase.Js_KnowledgeBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class JsResumeDto {	

	private Long userId;
	private List<JsEducationDto> jsEducationsDto;
	private List<JsExperienceDto> jsExperiencesDto;
	
	private List<@Valid Js_KnowledgeBase> jsForeignLangKnowledgesDto;
	private List<@Valid Js_KnowledgeBase> jsProgTechKnowledgesDto;
	
	private String image;
	private String presentation;
	private String linkGithub;
	private String linkLinkedin;
}
package kodlama.ht6.hrms.entities.Dtos.jsResumeBase;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class Js_KnowledgeBase {
	
	@Min(1)
	private Short knowledgeId;
	
	@Min(1)	@Max(6)
	private Short knowledgeLevelId;
}
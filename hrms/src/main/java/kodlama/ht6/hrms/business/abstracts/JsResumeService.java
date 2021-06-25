package kodlama.ht6.hrms.business.abstracts;

import java.util.List;

import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.entities.Dtos.JsResumeDto;
import kodlama.ht6.hrms.entities.concretes.JsResume;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.JsEducation;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.JsExperience;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.JsForeignLangKnowledge;
import kodlama.ht6.hrms.entities.concretes.jsResumeBase.JsProgTechKnowledge;

public interface JsResumeService {
	
	DataResult<JsResume> add(JsResumeDto jsResumeDto);
	
	DataResult<JsResume> resumeUpdate(JsResume jsResume);
	
	
	DataResult<JsResume> getById(Long id);
	
	DataResult<JsResume> getByIdFormatted(Long id);
	
	DataResult<List<JsResume>> getAll();
	
	
	DataResult<List<JsEducation>> getJsEducationByResume(Long id);
	
	DataResult<List<JsExperience>> getJsExperienceByResume(Long id);
	
	DataResult<List<JsProgTechKnowledge>> getByResumeIdOrderByKnowledgeLevel_idDesc_ProgTech(Long id);
	
	DataResult<List<JsForeignLangKnowledge>> getByResumeIdOrderByKnowledgeLevel_idDesc_FLanguage(Long id);
	

	DataResult<JsResumeDto> mapToJsResumeDto(String jsResumeDtoAsString);
}

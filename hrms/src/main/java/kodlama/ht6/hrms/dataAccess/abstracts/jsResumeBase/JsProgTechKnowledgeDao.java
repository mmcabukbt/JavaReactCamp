package kodlama.ht6.hrms.dataAccess.abstracts.jsResumeBase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.ht6.hrms.entities.concretes.jsResumeBase.JsProgTechKnowledge;

public interface JsProgTechKnowledgeDao  extends JpaRepository<JsProgTechKnowledge, Long>{
	
	JsProgTechKnowledge getByid(Long id);

	List<JsProgTechKnowledge> getByResumeIdOrderByKnowledgeLevel_idDesc(Long id);
}
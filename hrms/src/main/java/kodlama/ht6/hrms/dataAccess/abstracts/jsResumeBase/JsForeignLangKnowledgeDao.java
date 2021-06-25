package kodlama.ht6.hrms.dataAccess.abstracts.jsResumeBase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.ht6.hrms.entities.concretes.jsResumeBase.JsForeignLangKnowledge;

public interface JsForeignLangKnowledgeDao extends JpaRepository<JsForeignLangKnowledge, Long>{
	
	JsForeignLangKnowledge getByid(Long id);

	List<JsForeignLangKnowledge> getByResumeIdOrderByKnowledgeLevel_idDesc(Long id);
}

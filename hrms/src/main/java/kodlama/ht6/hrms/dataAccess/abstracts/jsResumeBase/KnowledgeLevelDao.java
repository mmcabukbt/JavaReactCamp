package kodlama.ht6.hrms.dataAccess.abstracts.jsResumeBase;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.ht6.hrms.entities.concretes.jsResumeBase.KnowledgeLevel;

public interface KnowledgeLevelDao  extends JpaRepository<KnowledgeLevel, Short>{
	
	KnowledgeLevel getByid(Short id);
}

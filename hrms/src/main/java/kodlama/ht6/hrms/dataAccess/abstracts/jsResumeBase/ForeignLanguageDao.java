package kodlama.ht6.hrms.dataAccess.abstracts.jsResumeBase;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.ht6.hrms.entities.concretes.jsResumeBase.ForeignLanguage;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage, Short>{
	
	ForeignLanguage getByid(Short id);
}

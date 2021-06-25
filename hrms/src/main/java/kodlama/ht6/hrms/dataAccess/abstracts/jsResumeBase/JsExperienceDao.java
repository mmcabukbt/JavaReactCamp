package kodlama.ht6.hrms.dataAccess.abstracts.jsResumeBase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.ht6.hrms.entities.concretes.jsResumeBase.JsExperience;

public interface JsExperienceDao extends JpaRepository<JsExperience, Long>{
	
	JsExperience getByid(Long id);
	
	List<JsExperience> getByResumeIdOrderByStartingYearDesc(Long id);
}

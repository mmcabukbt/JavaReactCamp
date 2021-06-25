package kodlama.ht6.hrms.dataAccess.abstracts.jsResumeBase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.ht6.hrms.entities.concretes.jsResumeBase.JsEducation;

public interface JsEducationDao extends JpaRepository<JsEducation, Long>{
	
	JsEducation getByid(Long id);
	
	List<JsEducation> getByResumeIdOrderByStartingYearDesc(Long id);
	
}

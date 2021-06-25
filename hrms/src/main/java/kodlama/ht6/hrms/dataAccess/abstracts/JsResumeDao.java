package kodlama.ht6.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.ht6.hrms.entities.concretes.JsResume;

public interface JsResumeDao extends JpaRepository<JsResume, Long>{
	
	JsResume getByid(Long id);
}

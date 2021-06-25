package kodlama.ht6.hrms.dataAccess.abstracts.jsResumeBase;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.ht6.hrms.entities.concretes.jsResumeBase.ProgrammingTech;

public interface ProgrammingTechDao extends JpaRepository<ProgrammingTech, Short>{
	
	ProgrammingTech getByid(Short id);
}

package kodlama.ht6.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.ht6.hrms.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Short>{
	Job getByid(Short id);
}
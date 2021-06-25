package kodlama.ht6.hrms.dataAccess.abstracts;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.ht6.hrms.entities.concretes.JobPost;

public interface JobPostDao extends JpaRepository<JobPost, Long>{
	
	JobPost getByid(Long id);
	
	List<JobPost> findByClosingDateAfter(Date zonedDateTime); 
	List<JobPost> findByActiveTrue();

	List<JobPost> findByActiveTrueOrderByClosingDate();
	List<JobPost> findByActiveTrueOrderByClosingDateDesc();

	List<JobPost> findByUserIdOrderByClosingDate(Long userId);
	List<JobPost> findByUserIdOrderByClosingDateDesc(Long userId);
	List<JobPost> findByUserIdAndActiveTrueOrderByClosingDate(Long userId);
	List<JobPost> findByUserIdAndActiveTrueOrderByClosingDateDesc(Long userId);
/*	
	List<User> findTop3ByAge();
	List<User> findByName(String name);
	List<User> findByNameIs(String name);
	List<User> findByNameEquals(String name); //*///
}
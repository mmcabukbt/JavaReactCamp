package kodlama.ht6.hrms.core.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.ht6.hrms.core.entities.concretes.Person;

public interface PersonDao extends JpaRepository<Person, Long>{
	
	Person getByTckNo(String tckNo);
	Person getByEmail(String email);
	
}

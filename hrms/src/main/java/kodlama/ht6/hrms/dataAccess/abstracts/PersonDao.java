package kodlama.ht6.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.ht6.hrms.entities.concretes.Person;

public interface PersonDao extends JpaRepository<Person, Integer>{
	
	Person getByTckNo(String tckNo);
}

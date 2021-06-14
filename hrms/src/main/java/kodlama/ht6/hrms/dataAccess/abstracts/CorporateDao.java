package kodlama.ht6.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.ht6.hrms.entities.concretes.Corporate;

public interface CorporateDao extends JpaRepository<Corporate, Integer>{

}

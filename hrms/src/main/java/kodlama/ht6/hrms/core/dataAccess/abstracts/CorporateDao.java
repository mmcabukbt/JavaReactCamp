package kodlama.ht6.hrms.core.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.ht6.hrms.core.entities.concretes.Corporate;

public interface CorporateDao extends JpaRepository<Corporate, Long>{

}

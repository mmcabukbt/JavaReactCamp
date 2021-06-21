package kodlama.ht6.hrms.core.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.ht6.hrms.core.entities.concretes.Staff;

public interface StaffDao extends JpaRepository<Staff,Long>{

}

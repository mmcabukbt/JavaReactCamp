package kodlama.ht6.hrms.core.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.ht6.hrms.core.entities.concretes.UnconfirmedUser;

public interface UnconfirmedUserDao extends JpaRepository<UnconfirmedUser, Integer>{
	public UnconfirmedUser getByUserId(int userId);

}

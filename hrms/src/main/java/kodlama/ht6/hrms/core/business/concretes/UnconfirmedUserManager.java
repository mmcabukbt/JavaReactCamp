package kodlama.ht6.hrms.core.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.core.business.abstracts.UnconfirmedUserService;
import kodlama.ht6.hrms.core.dataAccess.abstracts.UnconfirmedUserDao;
import kodlama.ht6.hrms.core.entities.concretes.UnconfirmedUser;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.SuccessDataResult;

@Service
public class UnconfirmedUserManager implements UnconfirmedUserService {

	private final UnconfirmedUserDao unconfirmedUserDao;

	@Autowired
	public UnconfirmedUserManager(UnconfirmedUserDao unconfirmedUserDao) {
		super();
		this.unconfirmedUserDao = unconfirmedUserDao;
	}

	public DataResult<List<UnconfirmedUser>> getAll() {
		return new SuccessDataResult<List<UnconfirmedUser>>(this.unconfirmedUserDao.findAll(), "All Unconfirmed Users listed!");
	}
}

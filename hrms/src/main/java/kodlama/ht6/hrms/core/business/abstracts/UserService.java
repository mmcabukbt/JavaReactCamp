package kodlama.ht6.hrms.core.business.abstracts;

import kodlama.ht6.hrms.core.entities.concretes.UnconfirmedUser;
import kodlama.ht6.hrms.core.entities.concretes.User;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.Result;

public interface UserService {

	DataResult<User> getUser(String email);
	DataResult<User> getUser(long id);
	
	Result addUnconfirmedUser(Long uId, String email);
	
	Result activateUser(UnconfirmedUser unconfirmedUser);
}

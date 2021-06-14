package kodlama.ht6.hrms.core.business.abstracts;

import kodlama.ht6.hrms.core.entities.concretes.Staff;
import kodlama.ht6.hrms.core.entities.concretes.UnconfirmedUser;
import kodlama.ht6.hrms.core.entities.concretes.User;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.Result;
import kodlama.ht6.hrms.entities.concretes.Corporate;
import kodlama.ht6.hrms.entities.concretes.JobSeeker;

public interface UserService {

	Result addJobSeeker(JobSeeker jobSeeker);

	Result addStaff(Staff staff);

	Result addCorporate(Corporate corporate);

	Result activateUser(UnconfirmedUser unconfirmedUser);

	DataResult<User> getUser(String email);
	
	DataResult<User> getPerson(String email, String TCkNo);
}

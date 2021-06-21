package kodlama.ht6.hrms.core.business.abstracts;

import kodlama.ht6.hrms.core.entities.DTOs.CorporateRegisterDto;
import kodlama.ht6.hrms.core.entities.DTOs.PersonRegisterDto;
import kodlama.ht6.hrms.core.entities.DTOs.UserLoginDto;
import kodlama.ht6.hrms.core.entities.concretes.UnconfirmedUser;
import kodlama.ht6.hrms.core.utilities.results.Result;

public interface AuthenticationService  {

	Result registerStaff(PersonRegisterDto stRegisterDto);
	Result registerJobSeeker(PersonRegisterDto jsRegisterDto);
	Result registerEmployer(CorporateRegisterDto emRegisterDto);
	Result userLogin(UserLoginDto uLoginRegisterDto);
	Result activateUser(UnconfirmedUser unconfirmedUser);
}

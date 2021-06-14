package kodlama.ht6.hrms.core.business.abstracts;

import kodlama.ht6.hrms.core.entities.DTOs.UserLoginDto;
import kodlama.ht6.hrms.core.utilities.results.Result;

public interface AuthenticationService  {

	Result userLogin(UserLoginDto uLoginRegisterDto);

}

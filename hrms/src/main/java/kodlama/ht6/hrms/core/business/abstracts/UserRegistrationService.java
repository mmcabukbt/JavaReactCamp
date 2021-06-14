package kodlama.ht6.hrms.core.business.abstracts;

import kodlama.ht6.hrms.core.entities.DTOs.CorporateRegisterDto;
import kodlama.ht6.hrms.core.entities.DTOs.JobSeekerRegisterDto;
import kodlama.ht6.hrms.core.entities.DTOs.StaffRegisterDto;
import kodlama.ht6.hrms.core.entities.concretes.UnconfirmedUser;
import kodlama.ht6.hrms.core.utilities.results.Result;

public interface UserRegistrationService {

	Result corporateRegister(CorporateRegisterDto corporateRegisterDto);

	Result jobSeekerRegister(JobSeekerRegisterDto jobSeekerRegisterDto);

	Result staffRegister(StaffRegisterDto staffRegisterDto);

	Result activateUser(UnconfirmedUser unconfirmedUser);
}

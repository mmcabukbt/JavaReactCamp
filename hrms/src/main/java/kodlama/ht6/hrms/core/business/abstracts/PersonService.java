package kodlama.ht6.hrms.core.business.abstracts;

import kodlama.ht6.hrms.core.entities.DTOs.PersonRegisterDto;
import kodlama.ht6.hrms.core.utilities.results.Result;

public interface PersonService{
	
	Result checkPersonToRegister(PersonRegisterDto personRegisterDto);
}

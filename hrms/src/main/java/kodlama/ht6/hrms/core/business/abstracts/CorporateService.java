package kodlama.ht6.hrms.core.business.abstracts;

import kodlama.ht6.hrms.core.entities.DTOs.CorporateRegisterDto;
import kodlama.ht6.hrms.core.utilities.results.Result;

public interface CorporateService {
	
	Result checkCorporateToRegister(CorporateRegisterDto corporateRegisterDto);
}

package kodlama.ht6.hrms.core.business.validators.userInfoValidator;

import kodlama.ht6.hrms.core.entities.DTOs.CorporateRegisterDto;
import kodlama.ht6.hrms.core.entities.DTOs.JobSeekerRegisterDto;
import kodlama.ht6.hrms.core.entities.DTOs.UserLoginDto;
import kodlama.ht6.hrms.core.utilities.results.Result;

public interface UserValidatorService {
	static final String PASSWORD_CHECK_FORMAT = "^(?=.*[0-9])(?=.*[a-zğüşıöç])(?=.*[A-ZĞÜŞİÖÇ])(?=.*[!@#&()–[{}]:;'.,?/*~$^+=<>]).{8,32}$"; //mkyong
	static final String TCKNO_CHECK_FORMAT = "^([1-9]{1}[0-9]{10})$";
	static final String PHONE_CHECK_FORMAT = "[0-9]{11,12}";
	static final String EMAIL_MY_PREFER_CHECK = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"; //mkyong
	static final String EMAIL_REGEX_com_CHECK = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	static final String EMAIL_OWASP_CHECK = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	static final String EMAIL_HTML_INPUT_BEFORE5 = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
	static final String EMAIL_HTML5_INPUT_CHECK = "^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";	

	Result personInfoValidate(JobSeekerRegisterDto personDto);
	Result corporateInfoValidate(CorporateRegisterDto corporateDto);
	Result userInfoValidate(UserLoginDto userDto);
	Result emailValidate(String email);
}
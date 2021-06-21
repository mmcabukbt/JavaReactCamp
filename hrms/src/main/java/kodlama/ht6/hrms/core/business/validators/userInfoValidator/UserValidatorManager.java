package kodlama.ht6.hrms.core.business.validators.userInfoValidator;

import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.core.entities.DTOs.CorporateRegisterDto;
import kodlama.ht6.hrms.core.entities.DTOs.PersonRegisterDto;
import kodlama.ht6.hrms.core.entities.DTOs.UserLoginDto;
import kodlama.ht6.hrms.core.utilities.results.ErrorResult;
import kodlama.ht6.hrms.core.utilities.results.Result;
import kodlama.ht6.hrms.core.utilities.results.SuccessResult;

@Service
public class UserValidatorManager  implements UserValidatorService {
//for CORPORATE - EMPLOYER
	@Override
	public Result corporateInfoValidate(CorporateRegisterDto corporateRegisterDto) {
		// company name can not be empty or less 10 char
		if (corporateRegisterDto.getCompanyName().length() < 10) {
			return new ErrorResult("[UserValidatorService[Corporate]]> User Company Name can not less 10 letters...");
		}
		// website can not be empty or less 10 char
		if (corporateRegisterDto.getWebsite().length() < 10) {
			return new ErrorResult("[UserValidatorService[Corporate]]> User Web addres can not less 10 letters...");
		}
		// website domain and email domain must be same
		if (!corporateRegisterDto.getWebsite()
				.endsWith("." + corporateRegisterDto.getEmail().substring(corporateRegisterDto.getEmail().lastIndexOf("@".codePointAt(0)) + 1))) {
			return new ErrorResult(
					"[UserValidatorService[Corporate]]> User website and email addreses must be on same domain");
		}
		// phone number can be only number and min 12 char
		if (!corporateRegisterDto.getPhone().matches(PHONE_CHECK_FORMAT)) {
			return new ErrorResult(
					"[UserValidatorService[Corporate]]> User phone number must be 11 or 12 digits with International Code (without '+' and 'space' "
			+ "like '901234567890' or '11234567890')");
		}
		// validate user info password & email > return result
		return this.userInfoValidateBase(corporateRegisterDto);
	}

// for PERSON - JOBSEEKER - STAFF
	@Override
	public Result personInfoValidate(PersonRegisterDto personregisterDto){
		// names can not be empty & min 2 char
		if ((personregisterDto.getFirstName().length() < 2) || (personregisterDto.getLastName().length() < 2)) {
			return new ErrorResult(
					"[UserValidatorService[Person]]> User First Name or Last Name can not less 2 letters...");
		}
		// tckno min 11 number digit - cant start '0'...  
		if (!personregisterDto.getTckNo().matches(TCKNO_CHECK_FORMAT)) {
			return new ErrorResult("[UserValidatorService[Person]]> User's TC ID Number must be Numeric 11 digits (cannot start with '0')!");
		}
		// Birth day??
		if ((personregisterDto.getYearOfBirth() < 1923)) {
			return new ErrorResult("[UserValidatorService[Person]]> Weird birth date!");
		}
		// validate user info password & email > return result
		return this.userInfoValidateBase(personregisterDto);
	}

// for USER - BASE
	@Override
	public  Result userInfoValidateBase(UserLoginDto userDto) {
		// password format check
		if (!userDto.getPassword().matches(PASSWORD_CHECK_FORMAT)) {
			return new ErrorResult(
					"[UserValidatorService[User]]> Password fields must be minimum 8 digits and must contain at least one number, lowercase, UPERCASE letter and one of symbols: '"
			+ PASSWORD_CHECK_FORMAT.substring(PASSWORD_CHECK_FORMAT.lastIndexOf("!".codePointAt(0)), PASSWORD_CHECK_FORMAT.lastIndexOf(">".codePointAt(0))+1)  + "' !!");
		}
		return this.emailValidate(userDto.getEmail());
	}

// email format check -not need check be empty -
	@Override
	public Result emailValidate(String email) {
		if (!email.matches(EMAIL_MY_PREFER_CHECK)) {
			return new ErrorResult("[UserValidatorService[User]]> Email is NOT valid!");
		}
		return new SuccessResult("[UserValidatorService[User]]> Validated!"); //Last Validate Common message
	}
}
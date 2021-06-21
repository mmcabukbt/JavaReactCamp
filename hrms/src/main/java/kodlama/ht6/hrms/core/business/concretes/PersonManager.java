package kodlama.ht6.hrms.core.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.core.adapters.mernisValidation.MernisValidationService;
import kodlama.ht6.hrms.core.business.abstracts.PersonService;
import kodlama.ht6.hrms.core.business.abstracts.UserService;
import kodlama.ht6.hrms.core.business.validators.userInfoValidator.UserValidatorService;
import kodlama.ht6.hrms.core.dataAccess.abstracts.PersonDao;
import kodlama.ht6.hrms.core.entities.DTOs.PersonRegisterDto;
import kodlama.ht6.hrms.core.entities.concretes.User;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.ErrorDataResult;
import kodlama.ht6.hrms.core.utilities.results.ErrorResult;
import kodlama.ht6.hrms.core.utilities.results.Result;
import kodlama.ht6.hrms.core.utilities.results.SuccessDataResult;
import kodlama.ht6.hrms.core.utilities.results.SuccessResult;

@Service
public class PersonManager implements PersonService{

	private final PersonDao personDao;
	private final UserService userService;
	private final UserValidatorService userValidatorService;
	private final MernisValidationService mernisValidationService;

	@Autowired
	public PersonManager(PersonDao personDao, UserService userService, UserValidatorService userValidatorService,
			MernisValidationService mernisValidationService) {
		super();
		this.personDao = personDao;
		this.userService = userService;
		this.userValidatorService = userValidatorService;
		this.mernisValidationService = mernisValidationService;
	}

	@Override
	public Result checkPersonToRegister(PersonRegisterDto personRegisterDto) {
		Result infoValidating = this.userValidatorService.personInfoValidate(personRegisterDto);
		if (!infoValidating.isSuccess()) {
			return new ErrorResult(infoValidating.getMessage());
		}
		Result personExitsts = this.getPerson(personRegisterDto.getEmail(), personRegisterDto.getTckNo());
		if (personExitsts.isSuccess()) {
			return new ErrorResult(personExitsts.getMessage());
		}		
		if (!this.mernisValidationService.isTCKNValid(personRegisterDto.getTckNo())) {
			return new ErrorResult("[PersonService[Person]]> Illegal Identity Number! User's identity number did not validate by (ONLY TCKNO check) MERNIS.");
		}
		return new SuccessResult("[PersonService]> Person> Returned!");	
	}
	
	private DataResult<User> getPerson(String email, String TCkNo) {
		DataResult<User> getUserResult = this.userService.getUser(email);
		return (getUserResult.isSuccess() || (this.personDao.getByTckNo(TCkNo) != null))
				? new SuccessDataResult<User>(getUserResult.getData(), "[PersonService]> Person> Already exists!")
				: new ErrorDataResult<User>(null, "[PersonService]> Person> Not found!");
	}
}

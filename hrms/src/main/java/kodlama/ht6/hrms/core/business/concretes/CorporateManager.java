package kodlama.ht6.hrms.core.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.core.business.abstracts.CorporateService;
import kodlama.ht6.hrms.core.business.abstracts.UserService;
import kodlama.ht6.hrms.core.business.validators.userInfoValidator.UserValidatorService;
import kodlama.ht6.hrms.core.entities.DTOs.CorporateRegisterDto;
import kodlama.ht6.hrms.core.entities.concretes.User;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.ErrorDataResult;
import kodlama.ht6.hrms.core.utilities.results.ErrorResult;
import kodlama.ht6.hrms.core.utilities.results.Result;
import kodlama.ht6.hrms.core.utilities.results.SuccessDataResult;
import kodlama.ht6.hrms.core.utilities.results.SuccessResult;

@Service
public class CorporateManager implements CorporateService {

	private final UserService userService;
	private final UserValidatorService userValidatorService;

	@Autowired
	public CorporateManager(UserService userService, UserValidatorService userValidatorService) {
		super();
		this.userService = userService;
		this.userValidatorService = userValidatorService;
	}

	@Override
	public Result checkCorporateToRegister(CorporateRegisterDto corporateRegisterDto) {
		Result infoValidating = this.userValidatorService.corporateInfoValidate(corporateRegisterDto);
		if (!infoValidating.isSuccess()) {
			return new ErrorResult(infoValidating.getMessage());
		}
		Result personExitsts = this.getCorporate(corporateRegisterDto.getEmail());
		if (personExitsts.isSuccess()) {
			return new ErrorResult(personExitsts.getMessage());
		}
		return new SuccessResult("[CorporateService]> Corporate> Returned!");	
	}
	
	private DataResult<User> getCorporate(String email) {
		DataResult<User> getUserResult = this.userService.getUser(email);
		return (getUserResult.isSuccess())
				? new SuccessDataResult<User>(getUserResult.getData(), "[CorporateService]> Corporate> Already exists!")
				: new ErrorDataResult<User>(null, "[CorporateService]> Corporate> Not found!");
	}


}

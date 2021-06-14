package kodlama.ht6.hrms.core.business.concretes;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.core.adapters.mernisValidation.MernisValidationService;
import kodlama.ht6.hrms.core.business.abstracts.UserRegistrationService;
import kodlama.ht6.hrms.core.business.abstracts.UserService;
import kodlama.ht6.hrms.core.business.validators.userInfoValidator.UserValidatorService;
import kodlama.ht6.hrms.core.entities.DTOs.CorporateRegisterDto;
import kodlama.ht6.hrms.core.entities.DTOs.JobSeekerRegisterDto;
import kodlama.ht6.hrms.core.entities.DTOs.StaffRegisterDto;
import kodlama.ht6.hrms.core.entities.concretes.Claim;
import kodlama.ht6.hrms.core.entities.concretes.Staff;
import kodlama.ht6.hrms.core.entities.concretes.UnconfirmedUser;
import kodlama.ht6.hrms.core.utilities.results.ErrorResult;
import kodlama.ht6.hrms.core.utilities.results.Result;
import kodlama.ht6.hrms.core.utilities.results.SuccessResult;
import kodlama.ht6.hrms.core.utilities.security.hashing.HashingService;
import kodlama.ht6.hrms.entities.concretes.Corporate;
import kodlama.ht6.hrms.entities.concretes.JobSeeker;

@Service
public class UserRegistrationManager implements UserRegistrationService {
	private List<Claim> defClaims = new ArrayList<Claim> ();
	private UserService userService;
	private HashingService hashingService;
	private UserValidatorService userValidatorService;
	private MernisValidationService mernisValidationService;

	@Autowired
	public UserRegistrationManager(UserService userService, UserValidatorService userValidatorService,
			MernisValidationService mernisValidationService, HashingService hashingService) {
		super();
		this.userService = userService;
		this.hashingService = hashingService;
		this.userValidatorService = userValidatorService;
		this.mernisValidationService = mernisValidationService;
		defClaims.add(new Claim((short)32730)); //  Unconfirmed User
	}

	@Override
	public Result corporateRegister(CorporateRegisterDto corporateRegisterDto) {
		Result infoValidating = this.userValidatorService.corporateInfoValidate(corporateRegisterDto);
		if (!infoValidating.isSuccess()) {
			return infoValidating;
		}
		Result corporateExitsts = this.userService.getUser(corporateRegisterDto.getEmail());
		if (corporateExitsts.isSuccess()) {
			return new ErrorResult(corporateExitsts.getMessage());
		}		
		defClaims.add(new Claim((short)32750)); // Unconfirmed Corporate
		Corporate corporate = new Corporate(0, corporateRegisterDto.getEmail(), null, null, false, defClaims,
				corporateRegisterDto.getCompanyName(), corporateRegisterDto.getWebsite(), corporateRegisterDto.getPhone());
		try {
			this.hashingService.createPasswordPBKDF2(corporate, corporateRegisterDto.getPassword());
			return this.userService.addCorporate(corporate);
		} catch (GeneralSecurityException e) {
			return new ErrorResult("[UserRegistrationService[Corporate]]> Internal Error! Password could not create! > " + e.getMessage());
		} finally { defClaims.remove(1); }
	}

	@Override
	public Result jobSeekerRegister(JobSeekerRegisterDto jobSeekerRegisterDto) {
		Result checkRegisterPerson = this.checkRegisterPersonDto(jobSeekerRegisterDto);
		if (!checkRegisterPerson.isSuccess()) {
			return checkRegisterPerson;
		}
		defClaims.add(new Claim((short)32760)); // Unconfirmed JobSeeker
		JobSeeker jobSeeker = new JobSeeker(0, jobSeekerRegisterDto.getEmail(), null, null, false, this.defClaims, jobSeekerRegisterDto.getTckNo(), 
				jobSeekerRegisterDto.getFirstName(), jobSeekerRegisterDto.getLastName(), jobSeekerRegisterDto.getYearOfBirth(), false);
		try {
			this.hashingService.createPasswordPBKDF2(jobSeeker, jobSeekerRegisterDto.getPassword());
			return this.userService.addJobSeeker(jobSeeker);
		} catch (GeneralSecurityException e) {
			return new ErrorResult("[UserRegistrationService[JobSeeker]]> Internal Error! Password could not create! > " + e.getMessage());
		} finally { defClaims.remove(1); }
	}

	@Override
	public Result staffRegister(StaffRegisterDto staffRegisterDto) {
		Result checkRegisterPerson = this.checkRegisterPersonDto(staffRegisterDto);
		if (!checkRegisterPerson.isSuccess()) {
			return checkRegisterPerson;
		}
		defClaims.add(new Claim((short)32740)); // Unconfirmed Staff
		Staff staff = new Staff(0, staffRegisterDto.getEmail(), null, null, false, defClaims, staffRegisterDto.getTckNo(), staffRegisterDto.getFirstName(),
				staffRegisterDto.getLastName(), staffRegisterDto.getYearOfBirth(), staffRegisterDto.getJobId(), staffRegisterDto.getSalary());
		try {
			this.hashingService.createPasswordPBKDF2(staff, staffRegisterDto.getPassword());
			return this.userService.addStaff(staff);
		} catch (GeneralSecurityException e) {
			return new ErrorResult("[UserRegistrationService[Staff]]> Internal Error! Password could not create! > " + e.getMessage());
		} finally { defClaims.remove(1); }
	}
	
	@Override
	public Result activateUser(UnconfirmedUser unconfirmedUser) {
		Result emailValidating = userValidatorService.emailValidate(unconfirmedUser.getEmail());
		return emailValidating.isSuccess() ? this.userService.activateUser(unconfirmedUser) : emailValidating;
	}
	
	private Result checkRegisterPersonDto(JobSeekerRegisterDto personRegisterDto) {
		Result infoValidating = this.userValidatorService.personInfoValidate(personRegisterDto);
		if (!infoValidating.isSuccess()) {
			return infoValidating;
		}
		Result personExitsts = this.userService.getPerson(personRegisterDto.getEmail(), personRegisterDto.getTckNo());
		if (personExitsts.isSuccess()) {
			return new ErrorResult(personExitsts.getMessage());
		}		
		if (!this.mernisValidationService.isTCKNValid(personRegisterDto.getTckNo())) {
			return new ErrorResult("[UserRegistrationService[JobSeeker]]> Illegal Identity Number! User's identity number did not validate by (ONLY TCKNO check) MERNIS.");
		}
		return new SuccessResult("[UserRegistrationService[Person]]> Checked!");
	}
}

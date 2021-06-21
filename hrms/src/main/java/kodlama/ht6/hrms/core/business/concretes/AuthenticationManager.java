package kodlama.ht6.hrms.core.business.concretes;

import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.business.abstracts.EmployerService;
import kodlama.ht6.hrms.business.abstracts.JobSeekerService;
import kodlama.ht6.hrms.core.business.abstracts.AuthenticationService;
import kodlama.ht6.hrms.core.business.abstracts.CorporateService;
import kodlama.ht6.hrms.core.business.abstracts.PersonService;
import kodlama.ht6.hrms.core.business.abstracts.StaffService;
import kodlama.ht6.hrms.core.business.abstracts.UserService;
import kodlama.ht6.hrms.core.entities.DTOs.CorporateRegisterDto;
import kodlama.ht6.hrms.core.entities.DTOs.PersonRegisterDto;
import kodlama.ht6.hrms.core.entities.DTOs.UserLoginDto;
import kodlama.ht6.hrms.core.entities.concretes.Staff;
import kodlama.ht6.hrms.core.entities.concretes.UnconfirmedUser;
import kodlama.ht6.hrms.core.entities.concretes.User;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.ErrorResult;
import kodlama.ht6.hrms.core.utilities.results.Result;
import kodlama.ht6.hrms.core.utilities.security.hashing.PBKDF2HashingService;
import kodlama.ht6.hrms.entities.concretes.Employer;
import kodlama.ht6.hrms.entities.concretes.JobSeeker;

@Service
public class AuthenticationManager implements AuthenticationService {

	private final UserService userService;
	private final StaffService staffService;
	private final PersonService personService;
	private final EmployerService employerService;
	private final CorporateService corporateService;
	private final JobSeekerService jobSeekerService;
	private final PBKDF2HashingService hashingService;
	
	@Autowired
	public AuthenticationManager(UserService userService, StaffService staffService, PersonService personService, EmployerService employerService,
			CorporateService corporateService, JobSeekerService jobSeekerService, 	PBKDF2HashingService hashingService) {
		super();
		this.userService = userService;
		this.staffService = staffService;
		this.personService = personService;
		this.corporateService = corporateService;
		this.jobSeekerService = jobSeekerService;
		this.employerService = employerService;
		this.hashingService = hashingService;
	}

	@Override
	public Result registerStaff(PersonRegisterDto stRegisterDto) {
		Result checkStaff = this.personService.checkPersonToRegister(stRegisterDto);
		if (!checkStaff.isSuccess()) {
			return checkStaff;
		}
		Staff staff = new Staff(0, stRegisterDto.getEmail(), null, null, false, null, stRegisterDto.getTckNo(),
				stRegisterDto.getFirstName(), stRegisterDto.getLastName(), stRegisterDto.getYearOfBirth(), null, 0.0);
		try {
			this.hashingService.createPassword(staff, stRegisterDto.getPassword());
			this.staffService.add(staff);
			return this.userService.addUnconfirmedUser(staff.getId(), staff.getEmail());
		} catch (GeneralSecurityException e) {
			return new ErrorResult("[AuthenticationService[Staff]]> Server Internal Error! Password could not create! > " + e.getMessage());
		}
	}	

	@Override
	public Result registerJobSeeker(PersonRegisterDto jsRegisterDto) {
		Result checkJobSeeker = this.personService.checkPersonToRegister(jsRegisterDto);
		if (!checkJobSeeker.isSuccess()) {
			return checkJobSeeker;
		}
		JobSeeker jobSeeker = new JobSeeker(0, jsRegisterDto.getEmail(), null, null, false, null, jsRegisterDto.getTckNo(),
				jsRegisterDto.getFirstName(), jsRegisterDto.getLastName(), jsRegisterDto.getYearOfBirth(), false);
		try {
			this.hashingService.createPassword(jobSeeker, jsRegisterDto.getPassword());
			this.jobSeekerService.add(jobSeeker);
			return this.userService.addUnconfirmedUser(jobSeeker.getId(), jobSeeker.getEmail());
		} catch (GeneralSecurityException e) {
			return new ErrorResult("[AuthenticationService[JobSeeker]]> Server Internal Error! Password could not create! > " + e.getMessage());
		}
	}

	@Override
	public Result registerEmployer(CorporateRegisterDto emRegisterDto) {
		Result checkEmployer = this.corporateService.checkCorporateToRegister(emRegisterDto);
		if (!checkEmployer.isSuccess()) {
			return checkEmployer;
		}
		Employer employer = new Employer(0, emRegisterDto.getEmail(), null, null, false, null, emRegisterDto.getCompanyName(),
				emRegisterDto.getWebsite(), emRegisterDto.getPhone(), null);
		try {
			this.hashingService.createPassword(employer, emRegisterDto.getPassword());
			this.employerService.add(employer);
			return this.userService.addUnconfirmedUser(employer.getId(), employer.getEmail());
		} catch (GeneralSecurityException e) {
			return new ErrorResult("[AuthenticationService[Employer]]> Server Internal Error! Password could not create! > " + e.getMessage());
		}
	}

	@Override
	public Result userLogin(UserLoginDto uLogin) {
		DataResult<User> getUserResult = this.userService.getUser(uLogin.getEmail());
		if (getUserResult.isSuccess()) {
			try {
				return this.hashingService.verifyPassword(getUserResult.getData(), uLogin.getPassword());
			} catch (GeneralSecurityException e) {
				return new ErrorResult(	"[AuthenticationService[User]]> Server Internal Error! Password could not verify! > "+ e.getMessage());
			}
		}
		return getUserResult;
	}
	
	@Override
	public Result activateUser(UnconfirmedUser unconfirmedUser) {
		return this.userService.activateUser(unconfirmedUser);
	}
}

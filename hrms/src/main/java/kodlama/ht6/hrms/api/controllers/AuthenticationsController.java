package kodlama.ht6.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.ht6.hrms.core.business.abstracts.AuthenticationService;
import kodlama.ht6.hrms.core.business.abstracts.UserRegistrationService;
import kodlama.ht6.hrms.core.entities.DTOs.CorporateRegisterDto;
import kodlama.ht6.hrms.core.entities.DTOs.JobSeekerRegisterDto;
import kodlama.ht6.hrms.core.entities.DTOs.StaffRegisterDto;
import kodlama.ht6.hrms.core.entities.DTOs.UserLoginDto;
import kodlama.ht6.hrms.core.entities.concretes.UnconfirmedUser;
import kodlama.ht6.hrms.core.utilities.results.ErrorResult;
import kodlama.ht6.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationsController {

	private AuthenticationService authenticationService;
	private UserRegistrationService userRegistrationService;

	@Autowired
	public AuthenticationsController(AuthenticationService authenticationService, UserRegistrationService userRegistrationService) {
		super();
		this.authenticationService = authenticationService;
		this.userRegistrationService = userRegistrationService;
	}

	@PostMapping("/signUp/js")
	public Result signUpJobSeeker(@RequestBody JobSeekerRegisterDto jsRegisterDto) {
		if (!jsRegisterDto.getPassword().equals(jsRegisterDto.getConfirmPassword())) {
			return new ErrorResult("[AuthenticationsController]> JobSeeker> Password and 'Confirm Password' are different. Please try again!");
		}
		return this.userRegistrationService.jobSeekerRegister(jsRegisterDto);
	}

	@PostMapping("/signUp/co")
	public Result signUpCorporate(@RequestBody CorporateRegisterDto coRegisterDto) {
		if (!coRegisterDto.getPassword().equals(coRegisterDto.getConfirmPassword())) {
			return new ErrorResult("[AuthenticationsController]> Corporate> Password and 'Confirm Password' are different. Please try again!");
		}
		return this.userRegistrationService.corporateRegister(coRegisterDto);
	}

	@PostMapping("/signUp/st")
	public Result signUpStaff(@RequestBody StaffRegisterDto stRegisterDto) {
		if (!stRegisterDto.getPassword().equals(stRegisterDto.getConfirmPassword())) {
			return new ErrorResult("[AuthenticationsController]> Staff> Password and 'Confirm Password' are different. Please try again!");
		}
		return this.userRegistrationService.staffRegister(stRegisterDto);
	}

	@PostMapping("/signIn")
	public Result signIn(@RequestBody UserLoginDto uLogin) {
		return this.authenticationService.userLogin(uLogin) ;
	}

	@GetMapping("/activation_GET")
	public Result activateUser(@RequestParam String email, @RequestParam int confirmId) {
		return this.userRegistrationService.activateUser(new UnconfirmedUser(confirmId, email, null));
	}

	@PostMapping("/activation_POSTwithUUID")
	public Result activateUser(@RequestBody UnconfirmedUser unconfirmedUser) {
		return this.userRegistrationService.activateUser(unconfirmedUser);
	}

}
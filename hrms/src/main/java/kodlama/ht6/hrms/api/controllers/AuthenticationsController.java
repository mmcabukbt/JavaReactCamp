package kodlama.ht6.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.ht6.hrms.core.business.abstracts.AuthenticationService;
import kodlama.ht6.hrms.core.business.abstracts.UnconfirmedUserService;
import kodlama.ht6.hrms.core.entities.DTOs.CorporateRegisterDto;
import kodlama.ht6.hrms.core.entities.DTOs.PersonRegisterDto;
import kodlama.ht6.hrms.core.entities.DTOs.UserLoginDto;
import kodlama.ht6.hrms.core.entities.concretes.UnconfirmedUser;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.ErrorResult;
import kodlama.ht6.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationsController {

	private final AuthenticationService authenticationService;
	private final UnconfirmedUserService unconfirmedUserService;
	
	@Autowired
	public AuthenticationsController(AuthenticationService authenticationService, UnconfirmedUserService unconfirmedUserService) {
		super();
		this.authenticationService = authenticationService;
		this.unconfirmedUserService = unconfirmedUserService;
	}

	@PostMapping("/signUp/st")
	public Result signUpStaff(@RequestBody PersonRegisterDto stRegisterDto) {
		if (!stRegisterDto.getPassword().equals(stRegisterDto.getConfirmPassword())) {
			return new ErrorResult("[AuthenticationsController]> Staff> Password and 'Confirm Password' are different. Please try again!");
		}
		return this.authenticationService.registerStaff(stRegisterDto); 	//  Unconfirmed Staff
	}

	@PostMapping("/signUp/js")
	public Result signUpJobSeeker(@RequestBody PersonRegisterDto jsRegisterDto) {
		if (!jsRegisterDto.getPassword().equals(jsRegisterDto.getConfirmPassword())) {
			return new ErrorResult("[AuthenticationsController]> JobSeeker> Password and 'Confirm Password' are different. Please try again!");
		}
		return this.authenticationService.registerJobSeeker(jsRegisterDto);		//  Unconfirmed JobSeeker
	} 

	@PostMapping("/signUp/em")
	public Result signUpEmployer(@RequestBody CorporateRegisterDto emRegisterDto) {
		if (!emRegisterDto.getPassword().equals(emRegisterDto.getConfirmPassword())) {
			return new ErrorResult("[AuthenticationsController]> Corporate> Password and 'Confirm Password' are different. Please try again!");
		}
		return this.authenticationService.registerEmployer(emRegisterDto);	//  Unconfirmed Employer
	}
	@PostMapping("/signIn")
	public Result signIn(@RequestBody UserLoginDto uLogin) {
		return this.authenticationService.userLogin(uLogin) ;
	}

	@PostMapping("/activation_POSTwithUUID")
	public Result activateUser(@RequestBody UnconfirmedUser unconfirmedUser) {
		return this.authenticationService.activateUser(unconfirmedUser);
	}

	@GetMapping("/activation_GET")
	public Result activateUser(@RequestParam String email, @RequestParam int confirmId) {
		return this.authenticationService.activateUser(new UnconfirmedUser(confirmId, email, null));
	}

	@GetMapping("/getUnconfirmedUsersAll")
	public DataResult<List<UnconfirmedUser>> getUnconfirmedUsersAll() {
		return this.unconfirmedUserService.getAll();
	}
}
package kodlama.ht6.hrms.core.business.concretes;

import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.core.business.abstracts.AuthenticationService;
import kodlama.ht6.hrms.core.business.abstracts.UserService;
import kodlama.ht6.hrms.core.entities.DTOs.UserLoginDto;
import kodlama.ht6.hrms.core.entities.concretes.User;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.ErrorResult;
import kodlama.ht6.hrms.core.utilities.results.Result;
import kodlama.ht6.hrms.core.utilities.security.hashing.HashingService;

@Service
public class AuthenticationManager implements AuthenticationService {

	private HashingService hashingService;
	private UserService userService;

	@Autowired
	public AuthenticationManager(HashingService hashingService, UserService userService) {
		super();
		this.userService = userService;
		this.hashingService = hashingService;
	}

	@Override
	public Result userLogin(UserLoginDto uLogin) {
		DataResult<User> getUserResult = this.userService.getUser(uLogin.getEmail());
		if (getUserResult.isSuccess()) {
			try {
				return this.hashingService.verifyPasswordPBKDF2(getUserResult.getData(), uLogin.getPassword());
			} catch (GeneralSecurityException e) {
				return new ErrorResult(	"[AuthenticationService[User]]> Internal Error! Password could not verify! > "+ e.getMessage());
			}
		}
		return getUserResult;
	}
}

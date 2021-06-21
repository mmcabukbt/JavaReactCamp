package kodlama.ht6.hrms.core.utilities.security.hashing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.core.entities.concretes.User;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.ErrorDataResult;
import kodlama.ht6.hrms.core.utilities.results.Result;
import kodlama.ht6.hrms.core.utilities.results.SuccessDataResult;
import kodlama.ht6.hrms.core.utilities.results.SuccessResult;

@Service
public class SHAHashingManager implements SHAHashingService {
	@Override	//		SHA-512
	public Result createPassword(User user, String password) throws NoSuchAlgorithmException {
		byte[] salt = this.getSalt();
		MessageDigest md = MessageDigest.getInstance(SHA_MESSAGE_DIGEST_ALGORITHM);
		md.update(salt);
		byte[] passwordHashSHA = md.digest(password.getBytes(StandardCharsets.UTF_8));
		user.setPasswordHash(passwordHashSHA);
		user.setPasswordSalt(salt);		
		return new SuccessResult("Password Hash & Salt created! (with " + SHA_MESSAGE_DIGEST_ALGORITHM + " Algorithm)");
	}

	@Override	//		SHA-512
	public DataResult<User> verifyPassword(User user, String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(user.getPasswordSalt());
		byte[] passwordHash512_verify = md.digest(password.getBytes(StandardCharsets.UTF_8));
		for (int i = 0; i < passwordHash512_verify.length; i++) {
			if (passwordHash512_verify[i] != user.getPasswordHash()[i]) {
				return new ErrorDataResult<User>(null, "[AuthenticationService[User]]> Invalid Password!");
			}
		}
		return new SuccessDataResult<User>(user, "[AuthenticationService[User]]> Password Accepted!");
	}
	
	private byte[] getSalt() {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[SALT_LENGTH_BYTE];
		random.nextBytes(salt);
		return salt;
	}
}

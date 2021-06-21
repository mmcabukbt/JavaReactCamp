package kodlama.ht6.hrms.core.utilities.security.hashing;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.stereotype.Service;

import kodlama.ht6.hrms.core.entities.concretes.User;
import kodlama.ht6.hrms.core.utilities.results.DataResult;
import kodlama.ht6.hrms.core.utilities.results.ErrorDataResult;
import kodlama.ht6.hrms.core.utilities.results.Result;
import kodlama.ht6.hrms.core.utilities.results.SuccessDataResult;
import kodlama.ht6.hrms.core.utilities.results.SuccessResult;

@Service
public class PBKDF2HashingManager implements PBKDF2HashingService {
	@Override	//		PBKDF2-512
	public Result createPassword(User user, String password) throws NoSuchAlgorithmException, InvalidKeySpecException{
		byte[] salt = this.getSalt();
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, PBKDF2_ITERATION_PARAMETER, PBKDF2_HASH_BIT_LENGTH);
		SecretKeyFactory factory = SecretKeyFactory.getInstance(PBKDF2_SECRETKEY_ALGORITHM);
		byte[] passwordHashPbk = factory.generateSecret(spec).getEncoded();
		user.setPasswordHash(passwordHashPbk);
		user.setPasswordSalt(salt);		
		return new SuccessResult("Password Hash & Salt created! (with " + PBKDF2_SECRETKEY_ALGORITHM  + " Algorithm)");
	}

	@Override	// 		PBKDF2-512
	public DataResult<User> verifyPassword(User user, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		KeySpec spec = new PBEKeySpec(password.toCharArray(), user.getPasswordSalt(), PBKDF2_ITERATION_PARAMETER, PBKDF2_HASH_BIT_LENGTH);
		SecretKeyFactory factory = SecretKeyFactory.getInstance(PBKDF2_SECRETKEY_ALGORITHM);
		byte[] passwordHashPbk_verify = factory.generateSecret(spec).getEncoded();
		for (int i = 0; i < passwordHashPbk_verify.length; i++) {
			if (passwordHashPbk_verify[i] != user.getPasswordHash()[i]) {
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

package kodlama.ht6.hrms.core.utilities.security.hashing;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import kodlama.ht6.hrms.core.entities.concretes.User;
import kodlama.ht6.hrms.core.utilities.results.Result;

public interface HashingService {
	
	static final int SALT_LENGTH_BYTE = 32;
	static final int PBKDF2_STRENGTH_PARAMETER = 65536;
	static final int PBKDF2_HASH_BIT_LENGTH = 512;
	static final String PBKDF2_SECRETKEY_ALGORITHM = "PBKDF2WithHmacSHA512";
	static final String SHA_MESSAGE_DIGEST_ALGORITHM = "SHA-512";
		
	Result createPasswordSHA(User user, String password) throws NoSuchAlgorithmException;
	Result verifyPasswordSHA(User user, String password) throws NoSuchAlgorithmException;
	Result createPasswordPBKDF2(User user, String password) throws NoSuchAlgorithmException, InvalidKeySpecException;
	Result verifyPasswordPBKDF2(User user, String password) throws NoSuchAlgorithmException, InvalidKeySpecException;
}

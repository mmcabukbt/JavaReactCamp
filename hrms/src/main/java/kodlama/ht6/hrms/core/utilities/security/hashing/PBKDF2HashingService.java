package kodlama.ht6.hrms.core.utilities.security.hashing;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import kodlama.ht6.hrms.core.entities.concretes.User;
import kodlama.ht6.hrms.core.utilities.results.Result;

public interface PBKDF2HashingService {

	static final int SALT_LENGTH_BYTE = 32;
	static final int PBKDF2_ITERATION_PARAMETER = 65536;
	static final int PBKDF2_HASH_BIT_LENGTH = 512;
	static final String PBKDF2_SECRETKEY_ALGORITHM = "PBKDF2WithHmacSHA512";
/*		
	static final int SALT_16_BYTE = 16;
	static final int SALT_32_BYTE = 32;
	static final int PBKDF2_32768_ITERATION = 32768;
	static final int PBKDF2_65536_ITERATION = 65536;
	static final int PBKDF2_131072_ITERATION = 131072;
	static final int HASH_128BIT_LENGTH = 128;
	static final int HASH_256BIT_LENGTH = 256;
	static final int HASH_512BIT_LENGTH = 512;
	static final String PBKDF2_SECRETKEY_WithHmacSHA1_ALGORITHM = "PBKDF2WithHmacSHA1";
	static final String PBKDF2_SECRETKEY_WithHmacSHA224_ALGORITHM = "PBKDF2WithHmacSHA224";
	static final String PBKDF2_SECRETKEY_WithHmacSHA256_ALGORITHM = "PBKDF2WithHmacSHA256";
	static final String PBKDF2_SECRETKEY_WithHmacSHA384_ALGORITHM = "PBKDF2WithHmacSHA384";
	static final String PBKDF2_SECRETKEY_WithHmacSHA512_ALGORITHM = "PBKDF2WithHmacSHA512";
//*////
	Result createPassword(User user, String password) throws NoSuchAlgorithmException, InvalidKeySpecException;
	Result verifyPassword(User user, String password) throws NoSuchAlgorithmException, InvalidKeySpecException;
}

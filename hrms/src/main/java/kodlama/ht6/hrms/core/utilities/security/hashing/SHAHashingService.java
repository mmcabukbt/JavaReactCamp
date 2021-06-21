package kodlama.ht6.hrms.core.utilities.security.hashing;

import java.security.NoSuchAlgorithmException;

import kodlama.ht6.hrms.core.entities.concretes.User;
import kodlama.ht6.hrms.core.utilities.results.Result;

public interface SHAHashingService {

	static final int SALT_LENGTH_BYTE = 32;
	static final String SHA_MESSAGE_DIGEST_ALGORITHM = "SHA-512";
/*	
	static final int SALT_16_BYTE = 16;
	static final int SALT_32_BYTE = 32;
	static final String MESSAGE_DIGEST_SHA1_ALGORITHM = "SHA-1";
	static final String MESSAGE_DIGEST_SHA224_ALGORITHM = "SHA-224";
	static final String MESSAGE_DIGEST_SHA256_ALGORITHM = "SHA-256";
	static final String MESSAGE_DIGEST_SHA384_ALGORITHM = "SHA-384";
	static final String MESSAGE_DIGEST_SHA512_ALGORITHM = "SHA-512";
	static final String MESSAGE_DIGEST_SHA512_224_ALGORITHM = "SHA-512/224";
	static final String MESSAGE_DIGEST_SHA512_256_ALGORITHM = "SHA-512/256";
//*///		
	Result createPassword(User user, String password) throws NoSuchAlgorithmException;
	Result verifyPassword(User user, String password) throws NoSuchAlgorithmException;
}

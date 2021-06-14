package kodlama.ht6.hrms.core.adapters.mernisValidation;

public interface MernisValidationService {
	//Simulates Validation with Quick TCKNO validator
	static final int TCKN_LENGTH = 11;
	static final String TCKNO_CHECK_FORMAT = "^([1-9]{1}[0-9]{10})$";
	
	boolean isTCKNValid(String identityNumber);
}
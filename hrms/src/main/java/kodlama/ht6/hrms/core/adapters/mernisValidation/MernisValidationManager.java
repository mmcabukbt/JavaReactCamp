package kodlama.ht6.hrms.core.adapters.mernisValidation;

import org.springframework.stereotype.Service;

@Service
public class MernisValidationManager implements MernisValidationService {
	
	public boolean isTCKNValid(String identityNumber) {
//		return true;
//*
		if (identityNumber == null
                || identityNumber.length() != TCKN_LENGTH
                || !identityNumber.matches(TCKNO_CHECK_FORMAT)) {
            return false;
        }
        int oddNumberTotal = 0;
        int evenNumberTotal = 0;
        int total = 0;
        int tenthNumber = 0;
        int eleventhNumber = 0;
        for (int i = 0; i < TCKN_LENGTH; i++) {
            int charNumber = Character.getNumericValue(identityNumber.toCharArray()[i]);
            if (i == 0 || i == 2 || i == 4 || i == 6 || i == 8) {
                oddNumberTotal = oddNumberTotal + charNumber;
                total = total + charNumber;
            } else if (i == 1 || i == 3 || i == 5 || i == 7) {
                evenNumberTotal = evenNumberTotal + charNumber;
                total = total + charNumber;
            } else if (i == 9) {
                tenthNumber = charNumber;
                total = total + charNumber;
            } else if (i == 10) {
                eleventhNumber = charNumber;
            }
        }
        return ((((oddNumberTotal * 7) - evenNumberTotal) % 10) == tenthNumber) && ((total % 10) == eleventhNumber) && (eleventhNumber % 2 == 0);//*////
    }
}

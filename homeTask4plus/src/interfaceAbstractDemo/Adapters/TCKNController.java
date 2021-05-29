package interfaceAbstractDemo.Adapters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import interfaceAbstractDemo.Adapters.pkgKPSPublicValidator.KPSPublic;
import interfaceAbstractDemo.Adapters.pkgKPSPublicValidator.KPSPublicSoap;



public class TCKNController {

	private String tcknServiceWSDLURI = "https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx?WSDL";
	private KPSPublicSoap kpsPublicSoap = null;

	public TCKNController() throws MalformedURLException {
		KPSPublic kpsPublic = null;
		kpsPublic = new KPSPublic(new URL(tcknServiceWSDLURI));
		this.kpsPublicSoap = kpsPublic.getKPSPublicSoap();
	}

	public boolean checkTCKNVality(String tckn, String name, String surname, String birthYear) {

		long tcknLong = 1L;
		try {
			tcknLong = Long.parseLong(tckn);
		} catch (NumberFormatException e) {
			return false;
		}
		int birthYearInt = 0;
		try {
			birthYearInt = Integer.parseInt(birthYear);
		} catch (NumberFormatException e) {
			return false;
		}

		boolean result = this.checkTCKNVality(tcknLong, name, surname, birthYearInt);
		return result;
	}

	public boolean checkTCKNVality(long tckn, String name, String surname, int birthYear) {
		Locale turkishLocale = new Locale("tr", "TR");
		// Name must be capital
		String nameUpper = name.toUpperCase(turkishLocale);
		// Surname must be capital
		String surnameUpper = surname.toUpperCase(turkishLocale);
		if(!this.tcknStructureChecker(tckn)){
			return false;
		}
		boolean result = this.kpsPublicSoap.tcKimlikNoDogrula(tckn, nameUpper, surnameUpper, birthYear);
		return result;
	}

	public boolean tcknStructureChecker(long tckn) {
		return this.tcknStructureChecker(String.valueOf(tckn));
		
	}
	public boolean tcknStructureChecker(String tckn) {
		int oddOnes = 0;
		int evenOnes = 0;
		int rule;
		int sum = 0;

		// tckn length must be equal to 11
		if (tckn.length() != 11) {
			return false;
		}
		// tckn cannot start with zero
		if (tckn.startsWith("0")) {
			return false;
		}

		char arrChar[] = tckn.toCharArray();
		int[] arr = new int[arrChar.length];
		for (int i = 0; i < arrChar.length; i++) {
			arr[i] = Integer.parseInt(arrChar[i] + "");
		}

		if (arr[10] % 2 != 0) {
			return false;
		}
		for (int i = 0; i < 9; i++) {
			sum += arr[i];
			if ((i % 2) == 0) {
				oddOnes += arr[i];
			} else {
				evenOnes += arr[i];
			}
		}

		sum += arr[9];

		rule = ((oddOnes * 7) - evenOnes);
		if (rule % 10 != arr[9]) {
			return false;
		}
		if ((sum % 10) != arr[10]) {
			return false;
		}
		return true;
	}

}

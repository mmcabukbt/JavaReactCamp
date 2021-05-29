package newestGamersCo.Adapters;

import java.net.MalformedURLException;

import interfaceAbstractDemo.Adapters.TCKNController;
import newestGamersCo.Abstract.PersonCheckService;
import newestGamersCo.Entities.Gamer;

public class MernisServiceAdapter implements PersonCheckService{

	@Override
	public boolean checkIfRealPerson(Gamer gamer) throws MalformedURLException {
//*		
		TCKNController tcknController = new TCKNController();
		return tcknController.checkTCKNVality(
				Long.parseLong(gamer.getNationalId()), gamer.getFirstName(), 
						gamer.getLastName(), gamer.getYearOfBirth()); //*////
		
		 //**************************************************************************************\\
		// TEST ED�LD� <> MERN�S K�ML�K KONTROL (CUSTOMER/PERSON KONTROL) DAH�L FULL �ALI�IYOR !! \\
	}// \\________________________________________________________________________________________//

}
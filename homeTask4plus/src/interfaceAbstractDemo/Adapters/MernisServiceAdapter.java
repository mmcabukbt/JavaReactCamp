package interfaceAbstractDemo.Adapters;

import java.net.MalformedURLException;

import interfaceAbstractDemo.Abstract.PersonCheckService;
import interfaceAbstractDemo.Entities.Customer;

public class MernisServiceAdapter implements PersonCheckService{

	@Override
	public boolean checkIfRealPerson(Customer customer) throws MalformedURLException {
//*		
		TCKNController tcknController = new TCKNController();
		return tcknController.checkTCKNVality(
				Long.parseLong(customer.getNationalityId()), customer.getFirstName(), 
				customer.getLastName(), customer.getDateOfBirth()); //*////
		
		 //**************************************************************************************\\
		// TEST EDÝLDÝ <> MERNÝS KÝMLÝK KONTROL (CUSTOMER/PERSON KONTROL) DAHÝL FULL ÇALIÞIYOR !! \\
	}// \\________________________________________________________________________________________//
}
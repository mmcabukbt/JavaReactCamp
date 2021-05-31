package interfaceAbstractDemo.adapters;

import java.net.MalformedURLException;

import interfaceAbstractDemo.abstracts.PersonCheckService;
import interfaceAbstractDemo.entities.Customer;

public class MernisServiceAdapter implements PersonCheckService{

	@Override
	public boolean checkIfRealPerson(Customer customer) throws MalformedURLException {
//*		
		TCKNController tcknController = new TCKNController();
		return tcknController.checkTCKNVality(
				Long.parseLong(customer.getNationalityId()), customer.getFirstName(), 
				customer.getLastName(), customer.getDateOfBirth()); //*////
		
		 //**************************************************************************************\\
		// TEST ED�LD� <> MERN�S K�ML�K KONTROL (CUSTOMER/PERSON KONTROL) DAH�L FULL �ALI�IYOR !! \\
	}// \\________________________________________________________________________________________//
}
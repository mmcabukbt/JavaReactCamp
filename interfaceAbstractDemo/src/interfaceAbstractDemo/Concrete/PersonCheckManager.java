package interfaceAbstractDemo.Concrete;

import interfaceAbstractDemo.Abstract.PersonCheckService;
import interfaceAbstractDemo.Entities.Customer;

public class PersonCheckManager implements PersonCheckService {

	@Override
	public boolean checkIfRealPerson(Customer customer) {
		// Bu class >  Servisleri Test Etme Amaçlý (Fake Servis olarak) Býrakýldý
		return false;
	}
}
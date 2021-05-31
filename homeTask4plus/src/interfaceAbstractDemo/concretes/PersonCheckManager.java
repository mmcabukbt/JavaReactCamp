package interfaceAbstractDemo.concretes;

import interfaceAbstractDemo.abstracts.PersonCheckService;
import interfaceAbstractDemo.entities.Customer;

public class PersonCheckManager implements PersonCheckService {

	@Override
	public boolean checkIfRealPerson(Customer customer) {
		// Bu class >  Servisleri Test Etme Amaçlý (Fake Servis olarak) Býrakýldý
		return false;
	}
}
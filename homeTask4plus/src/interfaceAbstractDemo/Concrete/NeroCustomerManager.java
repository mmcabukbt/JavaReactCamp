package interfaceAbstractDemo.Concrete;

import interfaceAbstractDemo.Abstract.BaseCustomerManager;
import interfaceAbstractDemo.Abstract.PersonCheckService;
import interfaceAbstractDemo.Entities.Customer;

public class NeroCustomerManager extends BaseCustomerManager {

	private PersonCheckService _personCheckService;

	public NeroCustomerManager(PersonCheckService personCheckService) {
		this._personCheckService = personCheckService;
	}

	@Override
	public void save(Customer customer) throws Exception {
		if (_personCheckService.checkIfRealPerson(customer)) {
			System.out.println(" <+> Saved to (Nero) database : " + customer.getFirstName() + " " + customer.getLastName());
		} else {
			System.out.println(" <-> The customer did not Save to Db, because... ");
			throw new Exception("WARNING! Not a valid person!");
		}
	}
}

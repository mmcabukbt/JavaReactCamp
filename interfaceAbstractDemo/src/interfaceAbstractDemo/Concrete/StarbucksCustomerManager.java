package interfaceAbstractDemo.Concrete;

import interfaceAbstractDemo.Abstract.BaseCustomerManager;
import interfaceAbstractDemo.Abstract.PersonCheckService;
import interfaceAbstractDemo.Entities.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager {

	private PersonCheckService _personCheckService;

	public StarbucksCustomerManager(PersonCheckService personCheckService) {
		this._personCheckService = personCheckService;
	}

	@Override
	public void save(Customer customer) throws Exception {
		if (_personCheckService.checkIfRealPerson(customer)) {
			System.out.println("Saved to (Starbucks) database : " + customer.getFirstName() + " " + customer.getLastName());
		} else {
		throw new Exception("WARNING! Not a valid person!");
		}
	}
}
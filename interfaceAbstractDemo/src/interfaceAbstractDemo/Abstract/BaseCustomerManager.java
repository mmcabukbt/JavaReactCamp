package interfaceAbstractDemo.Abstract;

import interfaceAbstractDemo.Entities.Customer;

public abstract class BaseCustomerManager implements CustomerService{
	
	public void save(Customer customer) throws Exception {
		System.out.println("Saved to database: " + customer.getFirstName() +" "+ customer.getLastName());		
	}
} 
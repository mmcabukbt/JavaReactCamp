package interfaceAbstractDemo.abstracts;

import java.net.MalformedURLException;

import interfaceAbstractDemo.entities.Customer;

public interface PersonCheckService {

	boolean checkIfRealPerson(Customer customer) throws MalformedURLException;
	
}
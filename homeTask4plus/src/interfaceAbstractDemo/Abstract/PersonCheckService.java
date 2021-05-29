package interfaceAbstractDemo.Abstract;

import java.net.MalformedURLException;

import interfaceAbstractDemo.Entities.Customer;

public interface PersonCheckService {

	boolean checkIfRealPerson(Customer customer) throws MalformedURLException;
	
}
package interfaceAbstractDemo;

import interfaceAbstractDemo.abstracts.BaseCustomerManager;
import interfaceAbstractDemo.adapters.MernisServiceAdapter;
import interfaceAbstractDemo.concretes.NeroCustomerManager;
import interfaceAbstractDemo.concretes.StarbucksCustomerManager;
import interfaceAbstractDemo.entities.Customer;

public class Main {

	public static void main(String[] args) {

		Customer customer = new Customer(12, "45454655", "MEHMET", "HIZLI", 1972);
		
		BaseCustomerManager starbucksCustomerManager =  
				new StarbucksCustomerManager(new MernisServiceAdapter());
//				new NeroCustomerManager(new MernisServiceAdapter());
		
		try {
			starbucksCustomerManager.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}

	 //**************************************************************************************\\
	// TEST EDÝLDÝ <> MERNÝS KÝMLÝK KONTROL (CUSTOMER/PERSON KONTROL) DAHÝL FULL ÇALIÞIYOR !! \\
//	\\________________________________________________________________________________________//


	}
}
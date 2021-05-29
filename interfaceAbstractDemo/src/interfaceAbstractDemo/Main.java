package interfaceAbstractDemo;

import interfaceAbstractDemo.Abstract.BaseCustomerManager;
import interfaceAbstractDemo.Adapters.MernisServiceAdapter;
import interfaceAbstractDemo.Concrete.NeroCustomerManager;
import interfaceAbstractDemo.Concrete.StarbucksCustomerManager;
import interfaceAbstractDemo.Entities.Customer;

public class Main {

	public static void main(String[] args) {

		Customer customer = new Customer(12, "1111111111", "MEHMET", "HIZLI", 1975);
		
		BaseCustomerManager starbucksCustomerManager =  
//				new StarbucksCustomerManager(new MernisServiceAdapter());
				new NeroCustomerManager(new MernisServiceAdapter());
		
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
package inheritance;

public class Main {

	public static void main(String[] args) {

		IndividualCustomer individualCustomer = new IndividualCustomer();
		individualCustomer.customerNumber = "1123215764";

		InstitutionalCustomer institutionalCustomer  = new InstitutionalCustomer();
		institutionalCustomer.customerNumber = "3454553456";

		UnionCustomer unionCustomer = new UnionCustomer();
		unionCustomer.customerNumber = "8766756767";

		CustomerManager customerManager = new CustomerManager();

		System.out.println("--add call_______________________");
		customerManager.add(institutionalCustomer);
		customerManager.add(individualCustomer);
		customerManager.add(unionCustomer);

		Customer[] customers = { individualCustomer, institutionalCustomer, unionCustomer};

		System.out.println("--addmultiple call________________");
		customerManager.addMultiple(customers);
		
		// ya da
		System.out.println("--#2->add call____________________");
		customerManager.add(customers);
	}
}
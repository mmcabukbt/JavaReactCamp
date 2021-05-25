package inheritance;

public class CustomerManager {
	/*
	 * public void add(IndividualCustomer customer){
	 * System.out.println(customer.customerNumber + " eklendi."); }
	 * 
	 * public void add(InstitutionalCustomer customer){
	 * System.out.println(customer.customerNumber + " eklendi."); }
	 */

	public void add(Customer customer) {
		System.out.println(customer.customerNumber + " eklendi.");

	}

	// Bulk Insert
	public void addMultiple(Customer[] customers) {
		for (Customer customer : customers) {
			add(customer);
		}
	}

	// YA DA ayný isimli farklý (signature-imzalý) parametreli - Bulk Insert
	public void add(Customer[] customers) {
		for (Customer customer : customers) {
			add(customer);
		}
	}
}
package interfaces;

public class Main {

	public static void main(String[] args) {
		//***********************				  *******************************\\	
// classes; SADECE 1 class extend EDEB�L�R, ANCAK 1 den FAZLA interface implement EDEB�L�R!
		//***********************				  *******************************//	
/*		ICustomerDao customerDao1 = new OracleCustomerDao();
		customerDao1.add();
		ICustomerDao customerDao2 = new MySqlCustomerDao();
		customerDao2.add(); //*///

//1. Y�ntem: CustomerManager i�indeki fielde(customerDao) buradan new ile Injection:

/*		CustomerManager customerManager = new CustomerManager();
		//Kullan�ma Dikkat: vvvvvALTTAvvvvvvv <Interface >>> Injection yapma...
		//customerManager.customerDao = new OracleCustomerDao();
		customerManager.customerDao = new MySqlCustomerDao();
		//customerManager.customerDao = new SqlServerCustomerDao();
		customerManager.add();///*/	
		
//2. Y�ntem: CustomerManager i�indeki fielde(customerDao >private yap�p eri�ime kapat�rsak daha iyi OOP) kendi Constructor unda Injection:
		
		CustomerManager customerManager = new CustomerManager(
				//new MySqlCustomerDao()
				//new OracleCustomerDao()
				new SqlServerCustomerDao()
				);
		customerManager.add();///*/

	}
}
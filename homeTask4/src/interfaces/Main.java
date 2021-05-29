package interfaces;

public class Main {

	public static void main(String[] args) {
		//***********************				  *******************************\\	
// classes; SADECE 1 class extend EDEBÝLÝR, ANCAK 1 den FAZLA interface implement EDEBÝLÝR!
		//***********************				  *******************************//	
/*		ICustomerDao customerDao1 = new OracleCustomerDao();
		customerDao1.add();
		ICustomerDao customerDao2 = new MySqlCustomerDao();
		customerDao2.add(); //*///

//1. Yöntem: CustomerManager içindeki fielde(customerDao) buradan new ile Injection:

/*		CustomerManager customerManager = new CustomerManager();
		//Kullanýma Dikkat: vvvvvALTTAvvvvvvv <Interface >>> Injection yapma...
		//customerManager.customerDao = new OracleCustomerDao();
		customerManager.customerDao = new MySqlCustomerDao();
		//customerManager.customerDao = new SqlServerCustomerDao();
		customerManager.add();///*/	
		
//2. Yöntem: CustomerManager içindeki fielde(customerDao >private yapýp eriþime kapatýrsak daha iyi OOP) kendi Constructor unda Injection:
		
		CustomerManager customerManager = new CustomerManager(
				//new MySqlCustomerDao()
				//new OracleCustomerDao()
				new SqlServerCustomerDao()
				);
		customerManager.add();///*/

	}
}
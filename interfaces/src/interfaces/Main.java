package interfaces;

public class Main {

	public static void main(String[] args) {

		// Logger ý dizi parametre geçelim
		/*
		 * DatabaseLogger databaseLogger = new DatabaseLogger();
		 * FileLogger fileLogger = new FileLogger(); 
		 * EmailLogger emailLogger = new EmailLogger(); 
		 * SmsLogger smsLogger = new SmsLogger();
		 * 
		 * CustomerManager customerManager = new CustomerManager(new Logger[]{
		 *  	databaseLogger,
		 *  	fileLogger,
		 *  	emailLogger,
		 *  	smsLogger });///
		 *//// >>> Daha basiti aþaðýda; aslýnda tek satýr

		// Artýk istediðimiz logger ý // ile açýp kapatabiliriz 
		// kodda baþka bir deðiþiklik yapmaya gerek yok
		CustomerManager customerManager = new CustomerManager(new Logger[] { 
						new DatabaseLogger(), 
						new FileLogger(),
						new EmailLogger(),
						new SmsLogger()
						});

		Customer customer1 = new Customer();
		customer1.setId(1);
		customer1.setFirstName("Engin");
		customer1.setLastName("Demiroð");

		customerManager.add(customer1);

	}
}
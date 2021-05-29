package interfaces;

public class Main {

	public static void main(String[] args) {

		// Logger � dizi parametre ge�elim
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
		 *//// >>> Daha basiti a�a��da; asl�nda tek sat�r

		// Art�k istedi�imiz logger � // ile a��p kapatabiliriz 
		// kodda ba�ka bir de�i�iklik yapmaya gerek yok
		CustomerManager customerManager = new CustomerManager(new Logger[] { 
						new DatabaseLogger(), 
						new FileLogger(),
						new EmailLogger(),
						new SmsLogger()
						});

		Customer customer1 = new Customer();
		customer1.setId(1);
		customer1.setFirstName("Engin");
		customer1.setLastName("Demiro�");

		customerManager.add(customer1);

	}
}
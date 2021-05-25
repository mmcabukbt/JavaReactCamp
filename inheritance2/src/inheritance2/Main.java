package inheritance2;

public class Main {

	public static void main(String[] args) {
		/* K�t� kod
		LogManager logManager = new LogManager();
		logManager.log(2); */
		
		CustomerManager customerManager = new CustomerManager();
		System.out.println("------------------------");
		customerManager.add(new DatabaseLogger());
		

		System.out.println("------------------------");
		Logger[] loggers = {new DatabaseLogger(), new FileLogger(), new EmailLogger()}; 

		//Overload edilmi� add metodu ile
		customerManager.add(loggers);
	}
}
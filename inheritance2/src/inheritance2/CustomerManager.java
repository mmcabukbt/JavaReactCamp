package inheritance2;

public class CustomerManager {
	public void add(Logger logger) {
		System.out.println("Müþteri eklendi!");
		
			logger.log();
	}

	public void add(Logger[] loggers) {
		System.out.println("Müþteri eklendi!");

		for (Logger logger : loggers) {
			logger.log();
		}
	}
}
package interfaces;

public class CustomerManager {

	Logger[] _loggers;

	public CustomerManager(Logger[] loggers) {
		this._loggers = loggers;
	}

	public void add(Customer customer) {
		System.out.println(" > M��teri eklendi: " + customer.getFirstName());
//Static yapt���m�z Utils in runLogger �a��r�yoruz
		Utils.runLoggers(_loggers, customer.getFirstName());
	}

	public void update(Customer customer) {
//		DatabaseLogger databaseLogger = new DatabaseLogger();
//		databaseLogger.log(customer.getFirstName() + " Veritaban�a logland�");
		System.out.println(" > M��teri g�ncellendi: " + customer.getFirstName());
		Utils.runLoggers(_loggers, customer.getFirstName());
	}

	public void delete(Customer customer) {
		System.out.println(" > M��teri silindi: " + customer.getFirstName());
		Utils.runLoggers(_loggers, customer.getFirstName());
	}
}
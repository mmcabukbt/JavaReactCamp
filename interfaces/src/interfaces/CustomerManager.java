package interfaces;

public class CustomerManager {

	Logger[] _loggers;

	public CustomerManager(Logger[] loggers) {
		this._loggers = loggers;
	}

	public void add(Customer customer) {
		System.out.println(" > Müþteri eklendi: " + customer.getFirstName());
//Static yaptýðýmýz Utils in runLogger çaðýrýyoruz
		Utils.runLoggers(_loggers, customer.getFirstName());
	}

	public void update(Customer customer) {
//		DatabaseLogger databaseLogger = new DatabaseLogger();
//		databaseLogger.log(customer.getFirstName() + " Veritabanýa loglandý");
		System.out.println(" > Müþteri güncellendi: " + customer.getFirstName());
		Utils.runLoggers(_loggers, customer.getFirstName());
	}

	public void delete(Customer customer) {
		System.out.println(" > Müþteri silindi: " + customer.getFirstName());
		Utils.runLoggers(_loggers, customer.getFirstName());
	}
}
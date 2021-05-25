package polymorphismDemo;

public class Main {

	public static void main(String[] args) {
		//EmailLogger logger = new EmailLogger();
		//logger.log("Log Mesajý loglandý");
		
		BaseLogger[] loggers = new BaseLogger[] {new FileLogger(), new EmailLogger(),
												new DatabaseLogger(), new ConsoleLogger()};
		for (BaseLogger baseLogger : loggers) {
			baseLogger.log("Log mesajý loglandý");
		}
		System.out.println("-----------------------------");
		
		CustomerManager customerManager = new CustomerManager(loggers);
		customerManager.add("Mehmet"); //Müþteri ekle ve otomatik tümüne logla
		
		
	}
}
package polymorphismDemo;

public class Main {

	public static void main(String[] args) {
		//EmailLogger logger = new EmailLogger();
		//logger.log("Log Mesaj� logland�");
		
		BaseLogger[] loggers = new BaseLogger[] {new FileLogger(), new EmailLogger(),
												new DatabaseLogger(), new ConsoleLogger()};
		for (BaseLogger baseLogger : loggers) {
			baseLogger.log("Log mesaj� logland�");
		}
		System.out.println("-----------------------------");
		
		CustomerManager customerManager = new CustomerManager(loggers);
		customerManager.add("Mehmet"); //M��teri ekle ve otomatik t�m�ne logla
		
		
	}
}
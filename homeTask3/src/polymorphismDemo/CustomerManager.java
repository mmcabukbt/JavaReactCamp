package polymorphismDemo;

public class CustomerManager {

	private BaseLogger[] baseLoggers; // ben dizi ekledim

	public CustomerManager(BaseLogger[] baseLoggers) {
		this.baseLoggers = baseLoggers;
	}

	public void add(String musteri) {
		System.out.println("> " + musteri + " Müþteri olarak eklendi");
		System.out.println("____________________________");
		
		for (BaseLogger baseLogger : baseLoggers) {
			baseLogger.log("Log mesajý loglandý");
		}
	}
}
package polymorphismDemo;

public class ConsoleLogger extends BaseLogger{
	public void log(String logMessage) {
		//String str = this.getClass().getSimpleName();
		System.out.println("<> Console logger : " + logMessage);
		
		//Extra gerekli farklý kodlar da yazýlabilir.
	}
}
package polymorphismDemo;

public class FileLogger extends BaseLogger{
	public void log(String logMessage) {
		//String str = this.getClass().getSimpleName();
		System.out.println("<> File logger : " + logMessage);
		
		//Extra gerekli farklý kodlar da yazýlabilir.
	}
}
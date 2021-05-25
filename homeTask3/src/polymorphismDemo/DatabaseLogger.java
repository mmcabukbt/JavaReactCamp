package polymorphismDemo;

public class DatabaseLogger extends BaseLogger{
	public void log(String logMessage) {
		//String str = this.getClass().getSimpleName();
		System.out.println("<> Database logger : " + logMessage);
		
		//Extra gerekli farklý kodlar da yazýlabilir.
	}

}
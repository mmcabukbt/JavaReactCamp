package polymorphismDemo;

public class EmailLogger extends BaseLogger{
	public void log(String logMessage) {
		//String str = this.getClass().getSimpleName();
		System.out.println("<> Email logger : " + logMessage);
		
		//Extra gerekli farkl� kodlar da yaz�labilir.
	}
}
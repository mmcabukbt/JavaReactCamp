package interfaces;

public class Utils {
	
	public static void runLoggers(Logger[] loggers, String message) {
		for (Logger logger : loggers) {
			logger.log(message);
		}	
	}
	
	///JAVA da d�� -�ST- class static OLAMAZ Ancak, inner i�te tan�mlanabilir.�rnek:
	/*public static class stClass{	}//*/////
}
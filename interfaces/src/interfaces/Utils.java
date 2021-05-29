package interfaces;

public class Utils {
	
	public static void runLoggers(Logger[] loggers, String message) {
		for (Logger logger : loggers) {
			logger.log(message);
		}	
	}
	
	///JAVA da dýþ -ÜST- class static OLAMAZ Ancak, inner içte tanýmlanabilir.Örnek:
	/*public static class stClass{	}//*/////
}
package interfaces;

public class SmsLogger implements Logger {

	@Override
	public void log(String message) {
		System.out.println(message + " SMS olarak g�nderildi");
	}
}
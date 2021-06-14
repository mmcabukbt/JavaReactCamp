package eTrade.core.utils.results;

public class Result {
	private boolean isSuccess;
	private String message = "No Info";
	
	public Result(boolean isSuccess, String message) {
		this(isSuccess);
		this.message = message;
	}

	public Result(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public String getMessage() {
		return message;
	}
}
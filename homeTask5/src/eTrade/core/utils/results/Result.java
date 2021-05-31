package eTrade.core.utils.results;

public class Result {
	public boolean isSuccess;
	public String message = "No Info";
	
	public Result(boolean isSuccess, String message) {
		this(isSuccess);
		this.message = message;
	}

	public Result(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
}
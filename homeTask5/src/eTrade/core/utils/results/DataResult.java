package eTrade.core.utils.results;

public class DataResult<T> extends Result {
	public T data;

	public DataResult(T data, boolean isSuccess, String message) {
		super(isSuccess, message);
		this.data = data;
	}

	public DataResult(T data, boolean isSuccess) {
		super(isSuccess);
		this.data = data;
	}
}
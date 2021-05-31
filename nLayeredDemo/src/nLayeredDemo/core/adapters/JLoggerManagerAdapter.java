package nLayeredDemo.core.adapters;

import nLayeredDemo.core.LoggerService;
import nLayeredDemo.jLogger.JLoggerManager;

public class JLoggerManagerAdapter implements LoggerService{
	
	private JLoggerManager jLoggerManager = new JLoggerManager(); 

	@Override
	public void log(String messsage) {
		jLoggerManager.log(messsage);		
	}
}
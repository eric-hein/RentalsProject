package com.m3.training.rentals.errorlogging;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ErrorLogger {
	public static final String Log4JCon= "src/main/resources/log4j.properties";
	
	private static Logger logger;
	
	public void info (String message) {
		ErrorLogger.logger.info(message);;
	}
	public void error (String message) {
		ErrorLogger.logger.error(message);
	}
	public void debug (String message) {
		ErrorLogger.logger.debug(message);
	}
	public void fatal (String message) {
		ErrorLogger.logger.fatal(message);
	}
	public void trace (String message) {
		ErrorLogger.logger.trace(message);
	}
	public void info (String message, Throwable t) {
		ErrorLogger.logger.info(message, t);
	}
	public void error (String message, Throwable t) {
		ErrorLogger.logger.error(message, t);
	}
	public void debug (String message, Throwable t) {
		ErrorLogger.logger.debug(message, t);
	}
	public void fatal (String message, Throwable t) {
		ErrorLogger.logger.fatal(message, t);
	}
	public void trace (String message, Throwable t) {
		ErrorLogger.logger.trace(message, t);
	}
	
	public ErrorLogger() {
		PropertyConfigurator.configure(Log4JCon);
		logger = Logger.getLogger(ErrorLogger.class);
	}
	

}

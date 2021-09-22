package br.com.ilia.exception;

public class HourException extends Exception{
	
	public HourException() {
		super("End Hour/Minute Greater than Start Hour/Minute");
	}
	public HourException (String msg) {
		super(msg);
	}

}

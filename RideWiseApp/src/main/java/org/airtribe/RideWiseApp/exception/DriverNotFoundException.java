package org.airtribe.RideWiseApp.exception;

public class DriverNotFoundException  extends RuntimeException{
    public DriverNotFoundException(String message) {
        super(message);
    }
}

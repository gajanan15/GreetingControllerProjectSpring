package com.bridgelabz.greetingcontroller.greetingcontroller.Exception;

public class GreetingControllerException extends RuntimeException {
    public ExceptionType type;

    public enum ExceptionType {
        NO_RECORD_FOUND;
    }

    public GreetingControllerException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}

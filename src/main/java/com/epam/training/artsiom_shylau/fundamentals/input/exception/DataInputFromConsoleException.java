package com.epam.training.artsiom_shylau.fundamentals.input.exception;

public class DataInputFromConsoleException extends Exception {

    public DataInputFromConsoleException() {}

    public DataInputFromConsoleException(String message) {
        super(message);
    }

    public DataInputFromConsoleException(Throwable throwable) {
        super(throwable);
    }

    public DataInputFromConsoleException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

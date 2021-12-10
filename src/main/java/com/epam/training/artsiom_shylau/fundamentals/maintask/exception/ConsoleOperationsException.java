package com.epam.training.artsiom_shylau.fundamentals.maintask.exception;

public class ConsoleOperationsException extends Exception {

    public ConsoleOperationsException() {}

    public ConsoleOperationsException(String message) {
        super(message);
    }

    public ConsoleOperationsException(Throwable throwable) {
        super(throwable);
    }

    public ConsoleOperationsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

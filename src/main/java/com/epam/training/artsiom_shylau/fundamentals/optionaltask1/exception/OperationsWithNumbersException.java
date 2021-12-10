package com.epam.training.artsiom_shylau.fundamentals.optionaltask1.exception;

public class OperationsWithNumbersException extends Exception {

    public OperationsWithNumbersException() {
    }

    public OperationsWithNumbersException(String message) {
        super(message);
    }

    public OperationsWithNumbersException(Throwable throwable) {
        super(throwable);
    }

    public OperationsWithNumbersException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

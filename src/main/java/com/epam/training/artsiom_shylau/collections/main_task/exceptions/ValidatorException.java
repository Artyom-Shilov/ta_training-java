package com.epam.training.artsiom_shylau.collections.main_task.exceptions;

public class ValidatorException extends Exception {

    public ValidatorException() {}

    public ValidatorException(String message) {
        super(message);
    }

    public ValidatorException(Throwable throwable) {
        super(throwable);
    }

    public ValidatorException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

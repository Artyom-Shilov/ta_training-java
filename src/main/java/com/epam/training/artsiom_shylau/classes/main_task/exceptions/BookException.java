package com.epam.training.artsiom_shylau.classes.main_task.exceptions;

public class BookException extends Exception {
    public BookException() {}

    public BookException(String message) {
        super(message);
    }

    public BookException(Throwable throwable) {
        super(throwable);
    }

    public BookException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

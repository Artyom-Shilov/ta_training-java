package com.epam.training.artsiom_shylau.classes.maintask.exceptions;

public class BookStorageException extends Exception {
    public BookStorageException() {}

    public BookStorageException(String message) {
        super(message);
    }

    public BookStorageException(Throwable throwable) {
        super(throwable);
    }

    public BookStorageException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

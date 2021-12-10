package com.epam.training.artsiom_shylau.collections.maintask.exceptions;

public class PostcardException extends Exception {

    public PostcardException() {}

    public PostcardException(String message) {
        super(message);
    }

    public PostcardException(Throwable throwable) {
        super(throwable);
    }

    public PostcardException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

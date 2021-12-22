package com.epam.training.artsiom_shylau.collections.maintask.exceptions;

public class FlowerException extends Exception {

    public FlowerException() {}

    public FlowerException(String message) {
        super(message);
    }

    public FlowerException(Throwable throwable) {
        super(throwable);
    }

    public FlowerException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

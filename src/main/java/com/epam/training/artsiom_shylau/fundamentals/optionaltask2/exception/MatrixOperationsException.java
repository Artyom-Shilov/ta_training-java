package com.epam.training.artsiom_shylau.fundamentals.optionaltask2.exception;

public class MatrixOperationsException extends Exception {

    public MatrixOperationsException() {
    }

    public MatrixOperationsException(String message) {
        super(message);
    }

    public MatrixOperationsException(Throwable throwable) {
        super(throwable);
    }

    public MatrixOperationsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

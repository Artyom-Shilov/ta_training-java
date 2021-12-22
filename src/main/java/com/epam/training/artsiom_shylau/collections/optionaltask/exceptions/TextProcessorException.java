package com.epam.training.artsiom_shylau.collections.optionaltask.exceptions;

public class TextProcessorException extends Exception {

    public TextProcessorException() {}

    public TextProcessorException(String message) {
        super(message);
    }

    public TextProcessorException(Throwable throwable) {
        super(throwable);
    }

    public TextProcessorException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

package com.epam.training.artsiom_shylau.fundamentals.main_task.exception;

public class MainTaskException extends Exception {

    public MainTaskException() {}

    public MainTaskException(String message) {
        super(message);
    }

    public MainTaskException(Throwable throwable) {
        super(throwable);
    }

    public MainTaskException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

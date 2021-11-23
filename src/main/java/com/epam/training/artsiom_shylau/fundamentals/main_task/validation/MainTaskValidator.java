package com.epam.training.artsiom_shylau.fundamentals.main_task.validation;

import com.epam.training.artsiom_shylau.fundamentals.main_task.exception.MainTaskException;

public class MainTaskValidator {

    public static void validateArray(String[] array) throws MainTaskException {
        if (array == null) {
            throw new MainTaskException("null as parameter");
        }
        if (array.length == 0) {
            throw new MainTaskException("array with zero length as parameter");
        }
    }
}

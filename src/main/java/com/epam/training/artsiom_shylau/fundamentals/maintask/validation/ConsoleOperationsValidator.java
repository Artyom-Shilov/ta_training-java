package com.epam.training.artsiom_shylau.fundamentals.maintask.validation;

import com.epam.training.artsiom_shylau.fundamentals.maintask.exception.ConsoleOperationsException;

public class ConsoleOperationsValidator {

    public static void validateArray(String[] array) throws ConsoleOperationsException {
        if (array == null) {
            throw new ConsoleOperationsException("null as parameter");
        }
        if (array.length == 0) {
            throw new ConsoleOperationsException("array with zero length as parameter");
        }
    }
}

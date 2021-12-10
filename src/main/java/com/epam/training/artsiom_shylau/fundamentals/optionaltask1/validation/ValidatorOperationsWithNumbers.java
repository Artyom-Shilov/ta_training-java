package com.epam.training.artsiom_shylau.fundamentals.optionaltask1.validation;

import com.epam.training.artsiom_shylau.fundamentals.optionaltask1.exception.OperationsWithNumbersException;

public class ValidatorOperationsWithNumbers {

    public static void validateArray(int[] array) throws OperationsWithNumbersException {
        if (array == null) {
            throw new OperationsWithNumbersException("null array as parameter");
        }
        if (array.length == 0) {
            throw new OperationsWithNumbersException("array with zero length as parameter");
        }
    }
}

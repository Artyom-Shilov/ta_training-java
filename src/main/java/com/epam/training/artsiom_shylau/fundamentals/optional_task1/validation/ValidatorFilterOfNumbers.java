package com.epam.training.artsiom_shylau.fundamentals.optional_task1.validation;

import com.epam.training.artsiom_shylau.fundamentals.optional_task1.exception.OptionalTask1Exception;

public class ValidatorFilterOfNumbers {

    public static void validateArray(int[] array) throws OptionalTask1Exception {
        if (array == null) {
            throw new OptionalTask1Exception("null array as parameter");
        }
        if (array.length == 0) {
            throw new OptionalTask1Exception("array with zero length as parameter");
        }
    }
}

package com.epam.training.artsiom_shylau.collections.main_task.validation;

import com.epam.training.artsiom_shylau.collections.main_task.entities.impl.flowers.Flower;
import com.epam.training.artsiom_shylau.collections.main_task.exceptions.ValidatorException;
import com.epam.training.artsiom_shylau.collections.main_task.exceptions.FloristException;

public class Validator {

    public static void validateObjectNull(Object object) throws ValidatorException {
        if (object == null) {
            throw new ValidatorException("null as object");
        }
    }

    public static void validatePositive(double value) throws ValidatorException {
        if (value < 0) {
            throw new ValidatorException("value must be positive");
        }
    }

    public static void validatePositive(int value) throws ValidatorException {
        if (value < 0) {
            throw new ValidatorException("value must be positive");
        }
    }

    public static void validateFlowerArray(Flower[] flowers) throws FloristException {
        if (flowers == null || flowers.length == 0) {
            throw new FloristException("null or zero length flowers array");
        }
        for (Flower flower : flowers) {
            if (flower == null) {
                throw new FloristException("null as flower");
            }
        }
    }
}

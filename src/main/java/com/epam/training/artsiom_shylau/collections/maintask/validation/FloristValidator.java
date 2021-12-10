package com.epam.training.artsiom_shylau.collections.maintask.validation;

import com.epam.training.artsiom_shylau.collections.maintask.entities.impl.flowers.Flower;
import com.epam.training.artsiom_shylau.collections.maintask.exceptions.FloristException;

public class FloristValidator {

    public static void validateObjectNull(Object object) throws FloristException {
        if (object == null) {
            throw new FloristException("null as object");
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

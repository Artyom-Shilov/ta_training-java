package com.epam.training.artsiom_shylau.fundamentals.optional_task2.validation;

import com.epam.training.artsiom_shylau.fundamentals.optional_task2.exception.OptionalTask2Exception;

public class ValidatorMatrixOperator {

    public static void validateSquareMatrix(int[][] matrix) throws OptionalTask2Exception {
        if (matrix == null) {
            throw new OptionalTask2Exception("square matrix is null");
        }
        if (matrix.length == 0) {
            throw new OptionalTask2Exception("number of rows is 0");
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != matrix.length) {
                throw new OptionalTask2Exception("matrix is not square");
            }
        }
    }

    public static void validateMatrix(int[][] matrix) throws OptionalTask2Exception {
        if (matrix == null) {
            throw new OptionalTask2Exception("matrix is null");
        }
        if (matrix.length == 0) {
            throw new OptionalTask2Exception("number of rows is 0");
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != matrix[0].length) {
                throw new OptionalTask2Exception("rows with different length");
            }
            if (matrix[i].length == 0) {
                throw new OptionalTask2Exception("length of row with index " + i +  " is 0");
            }
        }
    }

    public static void validateNumber(int number) throws OptionalTask2Exception {
        if (number < 0) {
            throw new OptionalTask2Exception("the parameter must be positive or zero");
        }
    }
}

package com.epam.training.artsiom_shylau.fundamentals.optionaltask2.validation;

import com.epam.training.artsiom_shylau.fundamentals.optionaltask2.exception.MatrixOperationsException;

public class ValidatorMatrixOperations {

    public static void validateSquareMatrix(int[][] matrix) throws MatrixOperationsException {
        if (matrix == null) {
            throw new MatrixOperationsException("square matrix is null");
        }
        if (matrix.length == 0) {
            throw new MatrixOperationsException("number of rows is 0");
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != matrix.length) {
                throw new MatrixOperationsException("matrix is not square");
            }
        }
    }

    public static void validateMatrix(int[][] matrix) throws MatrixOperationsException {
        if (matrix == null) {
            throw new MatrixOperationsException("matrix is null");
        }
        if (matrix.length == 0) {
            throw new MatrixOperationsException("number of rows is 0");
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != matrix[0].length) {
                throw new MatrixOperationsException("rows with different length");
            }
            if (matrix[i].length == 0) {
                throw new MatrixOperationsException("length of row with index " + i +  " is 0");
            }
        }
    }

    public static void validateNumber(int number) throws MatrixOperationsException {
        if (number < 0) {
            throw new MatrixOperationsException("the parameter must be positive or zero");
        }
    }
}

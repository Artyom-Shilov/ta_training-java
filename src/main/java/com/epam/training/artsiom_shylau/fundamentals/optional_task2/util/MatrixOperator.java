package com.epam.training.artsiom_shylau.fundamentals.optional_task2.util;

import com.epam.training.artsiom_shylau.fundamentals.optional_task2.exception.OptionalTask2Exception;
import com.epam.training.artsiom_shylau.fundamentals.optional_task2.validation.ValidatorMatrixOperator;

import java.util.Random;

public class MatrixOperator {

    public int[][] formSquareMatrixAndFillWithRandomNumbers(int size, int maxAbsoluteValue) throws OptionalTask2Exception {
        ValidatorMatrixOperator.validateNumber(size);
        int[][] matrix = new int[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Random().nextInt(maxAbsoluteValue + maxAbsoluteValue) - maxAbsoluteValue;
            }
        }
        return matrix;
    }

    public void sortLinesInOrderOfCertainColumnElementsIncreasing(int[][] matrix, int columnIndex) throws OptionalTask2Exception {
        ValidatorMatrixOperator.validateMatrix(matrix);
        ValidatorMatrixOperator.validateNumber(columnIndex);
        if (columnIndex > matrix.length - 1) {
            throw new OptionalTask2Exception("column index more than amount of lines");
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length - 1; j++) {
                if (matrix[j][columnIndex] > matrix[j + 1][columnIndex]) {
                    int[] c = matrix[j];
                    matrix[j] = matrix[j + 1];
                    matrix[j + 1] = c;
                }
            }
        }
    }

    public void sortColumnsInOrderOfCertainLineElementIncreasing(int[][] matrix, int lineIndex) throws OptionalTask2Exception {
        ValidatorMatrixOperator.validateMatrix(matrix);
        ValidatorMatrixOperator.validateNumber(lineIndex);
        if (lineIndex > matrix[0].length - 1) {
            throw new OptionalTask2Exception("line index more than amount of columns");
        }
        int[][] turnedMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                turnedMatrix[i][j] = matrix[j][i];
            }
        }
        sortLinesInOrderOfCertainColumnElementsIncreasing(turnedMatrix, lineIndex);
        for (int i = 0; i < turnedMatrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = turnedMatrix[i][j];
            }
        }
    }

    public int findTotalSumBetweenFirstAndSecondPositiveElementsOfEachLine(int[][] matrix) throws OptionalTask2Exception {
        ValidatorMatrixOperator.validateMatrix(matrix);
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            int firstPositiveElementIndex = -1;
            int secondPositiveElementIndex = -1;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0 && firstPositiveElementIndex == -1) {
                    firstPositiveElementIndex = j;
                    continue;
                }
                if (matrix[i][j] > 0 && firstPositiveElementIndex != -1) {
                    secondPositiveElementIndex = j;
                    break;
                }
            }
            if (firstPositiveElementIndex != -1 && secondPositiveElementIndex != -1) {
                for (int q = firstPositiveElementIndex + 1; q < secondPositiveElementIndex; q++) {
                    sum += matrix[i][q];
                }
            }
        }
        return sum;
    }

    public String printMatrix(int[][] matrix) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] line : matrix) {
            for (int element : line) {
                stringBuilder.append(String.format("%5d", element));
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}



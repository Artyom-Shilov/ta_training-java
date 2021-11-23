package com.epam.training.artsiom_shylau.fundamentals.optional_task2.launch;

import com.epam.training.artsiom_shylau.fundamentals.optional_task2.util.MatrixOperator;


public class Runner {
    public static void main(String[] args) {
        MatrixOperator operator = new MatrixOperator();
        try {
            System.out.println("Generated square matrix: ");
            int[][] squareMatrix = operator.formSquareMatrixAndFillWithRandomNumbers(4, 30);
            System.out.println(operator.printMatrix(squareMatrix));
            operator.sortColumnsInOrderOfCertainLineElementIncreasing(squareMatrix, 2);
            System.out.println("Sorted columns: ");
            System.out.println(operator.printMatrix(squareMatrix));
            operator.sortLinesInOrderOfCertainColumnElementsIncreasing(squareMatrix, 0);
            System.out.println("Sorted lines: ");
            System.out.println(operator.printMatrix(squareMatrix));
            System.out.println("total sum of elements between the first and the second positive elements in rows:  ");
            System.out.println(operator.findTotalSumBetweenFirstAndSecondPositiveElementsOfEachLine(squareMatrix));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

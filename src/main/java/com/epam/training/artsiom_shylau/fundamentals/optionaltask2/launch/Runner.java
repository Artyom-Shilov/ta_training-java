package com.epam.training.artsiom_shylau.fundamentals.optionaltask2.launch;

import com.epam.training.artsiom_shylau.fundamentals.optionaltask2.util.MatrixOperations;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;


public class Runner {

    private static Logger logger = Logger.getLogger(Runner.class);
    private static final int INDEX_OF_LINE_IN_MATRIX_FOR_SORT = 2;
    private static final int INDEX_OF_COLUMN_IN_MATRIX_FOR_SORT = 0;
    private static final int MATRIX_SIZE = 4;
    private static final int MAXIMUM_ABSOLUTE_VALUE_FOR_MATRIX_ELEMENTS = 30;

    public static void main(String[] args) {
        try {
            logger.log(Level.INFO,"Start of program" );
            MatrixOperations matrixOperator = new MatrixOperations();
            int[][] squareMatrix = matrixOperator.formSquareMatrixAndFillWithRandomNumbers(MATRIX_SIZE,
                                                                        MAXIMUM_ABSOLUTE_VALUE_FOR_MATRIX_ELEMENTS);
            logger.log(Level.INFO,"Generated square matrix: \n"
                    + matrixOperator.representMatrixAsString(squareMatrix));
            matrixOperator.sortColumnsInOrderOfCertainLineElementIncreasing(squareMatrix,
                                                                            INDEX_OF_LINE_IN_MATRIX_FOR_SORT);
            logger.log(Level.INFO, "Sorted columns in order of line with index "
                    + INDEX_OF_LINE_IN_MATRIX_FOR_SORT + " elements increasing: \n"
                    + matrixOperator.representMatrixAsString(squareMatrix));
            matrixOperator.sortLinesInOrderOfCertainColumnElementsIncreasing(squareMatrix,
                                                                            INDEX_OF_COLUMN_IN_MATRIX_FOR_SORT);
            logger.log(Level.INFO, "Sorted lines in order of column with index "
                    + INDEX_OF_COLUMN_IN_MATRIX_FOR_SORT + " elements increasing: \n"
                    + matrixOperator.representMatrixAsString(squareMatrix));
            logger.log(Level.INFO, "Total sum of elements between first and second positive elements in rows:"
                    +  matrixOperator.findTotalSumBetweenFirstAndSecondPositiveElementsOfEachLine(squareMatrix));
        } catch (Exception e){
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            logger.log(Level.ERROR, stringWriter.toString());
        }
    }
}

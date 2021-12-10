package com.epam.training.artsiom_shylau.fundamentals.optionaltask2;

import com.epam.training.artsiom_shylau.fundamentals.optionaltask2.exception.MatrixOperationsException;
import com.epam.training.artsiom_shylau.fundamentals.optionaltask2.util.MatrixOperations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SquareMatrixOperatorTest {

    private MatrixOperations operator;

    @Before
    public void setUp() {
        operator = new MatrixOperations();
    }

    @Test
    public void testSortLinesInOrderOfCertainColumnElementsIncreasingSquareMatrix() throws MatrixOperationsException {
        int[][] matrix = {{-5, 14, 9}, {-2, 0, 17}, {-6, 18, -13}};
        operator.sortLinesInOrderOfCertainColumnElementsIncreasing(matrix, 1);
        Assert.assertArrayEquals(new int[][]{{-2, 0, 17}, {-5, 14, 9}, {-6, 18, -13}}, matrix);
    }

    @Test
    public void testSortLinesInOrderOfCertainColumnElementsIncreasingMatrixNonSquareMatrix()
                                                                                    throws MatrixOperationsException {
        int[][] matrix = {{-5, 14, 9}, {-2, 0, 17}};
        operator.sortLinesInOrderOfCertainColumnElementsIncreasing(matrix, 1);
        Assert.assertArrayEquals(new int[][]{{-2, 0, 17}, {-5, 14, 9}}, matrix);
    }

    @Test(expected = MatrixOperationsException.class)
    public void testSortLinesInOrderOfCertainColumnElementsIncreasingNull() throws MatrixOperationsException {
        operator.sortLinesInOrderOfCertainColumnElementsIncreasing(null, 1);
    }

    @Test(expected = MatrixOperationsException.class)
    public void testSortLinesInOrderOfCertainColumnElementsIncreasingNegativeColumnIndex()
                                                                                    throws MatrixOperationsException {
        int[][] matrix = {{-5, 14, 9}, {-2, 17}};
        operator.sortLinesInOrderOfCertainColumnElementsIncreasing(matrix, -4);
    }

    @Test(expected = MatrixOperationsException.class)
    public void testSortLinesInOrderOfCertainColumnElementsIncreasingZeroRows() throws MatrixOperationsException {
        operator.sortLinesInOrderOfCertainColumnElementsIncreasing(new int[0][4], 2);
    }

    @Test(expected = MatrixOperationsException.class)
    public void testSortLinesInOrderOfCertainColumnElementsIncreasingZeroColumns() throws MatrixOperationsException {
        operator.sortLinesInOrderOfCertainColumnElementsIncreasing(new int[5][0], 2);
    }

    @Test(expected = MatrixOperationsException.class)
    public void testSortLinesInOrderOfCertainColumnElementsIncreasingNotMatrix() throws MatrixOperationsException {
        int[][] matrix = {{-5, 14, 9}, {-2, 17}};
        operator.sortLinesInOrderOfCertainColumnElementsIncreasing(matrix, 0);
    }

    @Test(expected = MatrixOperationsException.class)
    public void testSortLinesInOrderOfCertainColumnElementsIncreasingExceedColumnIndex()
                                                                                    throws MatrixOperationsException {
        int[][] matrix = {{-5, 14}, {-2, 17}};
        operator.sortLinesInOrderOfCertainColumnElementsIncreasing(matrix, 2);
    }

    @Test
    public void testFindTotalSumBetweenFirstAndSecondPositiveElementsOfEachLine() throws MatrixOperationsException {
        int[][] matrix = {{-5, 14, -9, 4}, {2, 0, 17, 0}, {-6, 18, -13, -9}, {1, -2, -3, 4}};
        Assert.assertEquals(-14, operator.findTotalSumBetweenFirstAndSecondPositiveElementsOfEachLine(matrix));
    }

    @Test(expected = MatrixOperationsException.class)
    public void testFindTotalSumBetweenFirstAndSecondPositiveElementsOfEachLineNullAsArgument()
            throws MatrixOperationsException {
        operator.findTotalSumBetweenFirstAndSecondPositiveElementsOfEachLine(null);
    }


    @Test(expected = MatrixOperationsException.class)
    public void testFindTotalSumBetweenFirstAndSecondPositiveElementsOfEachLineZeroRows()
                                                                                    throws MatrixOperationsException {
        operator.findTotalSumBetweenFirstAndSecondPositiveElementsOfEachLine(new int[0][4]);
    }

    @Test(expected = MatrixOperationsException.class)
    public void testFindTotalSumBetweenFirstAndSecondPositiveElementsOfEachLineZeroColumns()
            throws MatrixOperationsException {
        operator.findTotalSumBetweenFirstAndSecondPositiveElementsOfEachLine(new int[5][0]);
    }

    @Test(expected = MatrixOperationsException.class)
    public void testFindTotalSumBetweenFirstAndSecondPositiveElementsOfEachLineNotMatrix()
                                                                                    throws MatrixOperationsException {
        int[][] matrix = {{-5, 14, 9}, {-2, 17}};
        operator.findTotalSumBetweenFirstAndSecondPositiveElementsOfEachLine(matrix);
    }

    @Test
    public void testSortColumnsInOrderOfCertainLineElementIncreasingMatrixSquareMatrix()
                                                                                    throws MatrixOperationsException {
        int[][] matrix = {{-5, 14, 9}, {-2, 0, 17}, {-6, 18, -13}};
        operator.sortColumnsInOrderOfCertainLineElementIncreasing(matrix, 2);
        Assert.assertArrayEquals(new int[][]{{9, -5, 14}, {17, -2, 0}, {-13, -6, 18}}, matrix);
    }

    @Test(expected = MatrixOperationsException.class)
    public void testSortColumnsInOrderOfCertainLineElementIncreasingNull() throws MatrixOperationsException {
        operator.sortColumnsInOrderOfCertainLineElementIncreasing(null, 1);
    }

    @Test(expected = MatrixOperationsException.class)
    public void testSortColumnsInOrderOfCertainLineElementIncreasingNegativeLineIndex()
                                                                                    throws MatrixOperationsException {
        int[][] matrix = {{-5, 14, 9}, {-2, 17, 5}};
        operator.sortColumnsInOrderOfCertainLineElementIncreasing(matrix, -4);
    }

    @Test(expected = MatrixOperationsException.class)
    public void testSortColumnsInOrderOfCertainLineElementIncreasingZeroRows() throws MatrixOperationsException {
        operator.sortColumnsInOrderOfCertainLineElementIncreasing(new int[0][4], 1);
    }

    @Test(expected = MatrixOperationsException.class)
    public void testSortColumnsInOrderOfCertainLineElementIncreasingZeroColumns() throws MatrixOperationsException {
        operator.sortColumnsInOrderOfCertainLineElementIncreasing(new int[5][0], 1);
    }

    @Test(expected = MatrixOperationsException.class)
    public void tesSortColumnsInOrderOfCertainLineElementIncreasingNotMatrix() throws MatrixOperationsException {
        int[][] matrix = {{-5, 14, 9}, {-2, 17}};
        operator.sortColumnsInOrderOfCertainLineElementIncreasing(matrix, 0);
    }

    @Test(expected = MatrixOperationsException.class)
    public void testSortColumnsInOrderOfCertainLineElementIncreasingExceedLineIndex() throws MatrixOperationsException {
        int[][] matrix = {{-5, 14}, {-2, 17}};
        operator.sortColumnsInOrderOfCertainLineElementIncreasing(matrix, 2);
    }

    @Test
    public void testFormSquareMatrixAndFillWithRandomNumbers() throws MatrixOperationsException {
        int[][] squareMatrix = operator.formSquareMatrixAndFillWithRandomNumbers(4, 30);
        Assert.assertEquals(squareMatrix.length, squareMatrix[0].length);
    }

    @Test
    public void testFormSquareMatrixAndFillWithRandomNumberZeroSizeAsParameter() throws MatrixOperationsException {
        int expected = 0;
        int actual = operator.formSquareMatrixAndFillWithRandomNumbers(0, 30).length;
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = MatrixOperationsException.class)
    public void testFormSquareMatrixAndFillWithRandomNumbersNegativeSizeAsParameter() throws MatrixOperationsException {
        operator.formSquareMatrixAndFillWithRandomNumbers(-4, 30);
    }
}


package com.epam.training.artsiom_shylau.fundamentals.optional_task2;

import com.epam.training.artsiom_shylau.fundamentals.optional_task2.exception.OptionalTask2Exception;
import com.epam.training.artsiom_shylau.fundamentals.optional_task2.util.MatrixOperator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SquareMatrixOperatorTest {

    private MatrixOperator operator;

    @Before
    public void setUp () {
        operator = new MatrixOperator();
    }

    @Test
    public void testSortLinesInOrderOfCertainColumnElementsIncreasingSquareMatrix() throws OptionalTask2Exception {
        int[][] matrix = {{-5, 14, 9}, {-2, 0, 17}, {-6, 18, -13}};
        int[] firstRow = matrix[0];
        int[] secondRow = matrix[1];
        int[] thirdRow = matrix[2];
        operator.sortLinesInOrderOfCertainColumnElementsIncreasing(matrix, 1);
        Assert.assertTrue(matrix[0] == secondRow && matrix[1] == firstRow
                && matrix[2] == thirdRow);
    }

    @Test
    public void testSortLinesInOrderOfCertainColumnElementsIncreasingMatrixNonSquareMatrix() throws OptionalTask2Exception {
        int[][] matrix = {{-5, 14, 9}, {-2, 0, 17}};
        int[] firstRow = matrix[0];
        int[] secondRow = matrix[1];
        operator.sortLinesInOrderOfCertainColumnElementsIncreasing(matrix, 1);
        Assert.assertTrue(matrix[0] == secondRow && matrix[1] == firstRow);
    }

    @Test(expected = OptionalTask2Exception.class)
    public void testSortLinesInOrderOfCertainColumnElementsIncreasingNull() throws OptionalTask2Exception {
        operator.sortLinesInOrderOfCertainColumnElementsIncreasing(null, 1);
    }

    @Test(expected = OptionalTask2Exception.class)
    public void testSortLinesInOrderOfCertainColumnElementsIncreasingNegativeColumnIndex() throws OptionalTask2Exception {
        int[][] matrix = {{-5, 14, 9}, {-2, 17}};
        operator.sortLinesInOrderOfCertainColumnElementsIncreasing(matrix, -4);
    }

    @Test(expected = OptionalTask2Exception.class)
    public void testSortLinesInOrderOfCertainColumnElementsIncreasingZeroRows() throws OptionalTask2Exception {
        operator.sortLinesInOrderOfCertainColumnElementsIncreasing(new int[0][4], 2);
    }

    @Test(expected = OptionalTask2Exception.class)
    public void testSortLinesInOrderOfCertainColumnElementsIncreasingZeroColumns() throws OptionalTask2Exception {
        operator.sortLinesInOrderOfCertainColumnElementsIncreasing(new int[5][0], 2);
    }

    @Test(expected = OptionalTask2Exception.class)
    public void testSortLinesInOrderOfCertainColumnElementsIncreasingNotMatrix() throws OptionalTask2Exception {
        int[][] matrix = {{-5, 14, 9}, {-2, 17}};
        operator.sortLinesInOrderOfCertainColumnElementsIncreasing(matrix, 0);
    }

    @Test(expected = OptionalTask2Exception.class)
    public void testSortLinesInOrderOfCertainColumnElementsIncreasingExceedColumnIndex() throws OptionalTask2Exception {
        int[][] matrix = {{-5, 14}, {-2, 17}};
        operator.sortLinesInOrderOfCertainColumnElementsIncreasing(matrix, 2);
    }

    @Test
    public void testFindTotalSumBetweenFirstAndSecondPositiveElementsOfEachLine() throws OptionalTask2Exception {
        int[][] matrix = {{-5, 14, -9, 4}, {2, 0, 17, 0}, {-6, 18, -13, -9}, {1, -2, -3, 4}};
        int expected = -14;
        int actual = operator.findTotalSumBetweenFirstAndSecondPositiveElementsOfEachLine(matrix);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = OptionalTask2Exception.class)
    public void testFindTotalSumBetweenFirstAndSecondPositiveElementsOfEachLineNull() throws OptionalTask2Exception {
        operator.findTotalSumBetweenFirstAndSecondPositiveElementsOfEachLine(null);
    }


    @Test(expected = OptionalTask2Exception.class)
    public void testFindTotalSumBetweenFirstAndSecondPositiveElementsOfEachLineZeroRows() throws OptionalTask2Exception {
        operator.findTotalSumBetweenFirstAndSecondPositiveElementsOfEachLine(new int[0][4]);
    }

    @Test(expected = OptionalTask2Exception.class)
    public void testFindTotalSumBetweenFirstAndSecondPositiveElementsOfEachLineZeroColumns() throws OptionalTask2Exception {
        operator.findTotalSumBetweenFirstAndSecondPositiveElementsOfEachLine(new int[5][0]);
    }

    @Test(expected = OptionalTask2Exception.class)
    public void testFindTotalSumBetweenFirstAndSecondPositiveElementsOfEachLineNotMatrix() throws OptionalTask2Exception {
        int[][] matrix = {{-5, 14, 9}, {-2, 17}};
        operator.findTotalSumBetweenFirstAndSecondPositiveElementsOfEachLine(matrix);
    }

    @Test
    public void testSortColumnsInOrderOfCertainLineElementIncreasingMatrixSquareMatrix() throws OptionalTask2Exception {
        int[][] matrix = {{-5, 14, 9}, {-2, 0, 17}, {-6, 18, -13}};
        int[] expectedFirstRow = {9, -5, 14};
        int[] expectedSecondRow = {17, -2, 0};
        int[] expectedThirdRow = {-13, -6, 18};
        operator.sortColumnsInOrderOfCertainLineElementIncreasing(matrix, 2);
        Assert.assertTrue(Arrays.equals(expectedFirstRow, matrix[0])
                && Arrays.equals(expectedSecondRow, matrix[1]) && Arrays.equals(expectedThirdRow, matrix[2]));
    }

    @Test(expected = OptionalTask2Exception.class)
    public void testSortColumnsInOrderOfCertainLineElementIncreasingNull() throws OptionalTask2Exception {
        operator.sortColumnsInOrderOfCertainLineElementIncreasing(null, 1);
    }

    @Test(expected = OptionalTask2Exception.class)
    public void testSortColumnsInOrderOfCertainLineElementIncreasingNegativeLineIndex() throws OptionalTask2Exception {
        int[][] matrix = {{-5, 14, 9}, {-2, 17}};
        operator.sortColumnsInOrderOfCertainLineElementIncreasing(matrix, -4);
    }

    @Test(expected = OptionalTask2Exception.class)
    public void testSortColumnsInOrderOfCertainLineElementIncreasingZeroRows() throws OptionalTask2Exception {
        operator.sortColumnsInOrderOfCertainLineElementIncreasing(new int[0][4], 1);
    }

    @Test(expected = OptionalTask2Exception.class)
    public void testSortColumnsInOrderOfCertainLineElementIncreasingZeroColumns() throws OptionalTask2Exception {
        operator.sortColumnsInOrderOfCertainLineElementIncreasing(new int[5][0], 1);
    }

    @Test(expected = OptionalTask2Exception.class)
    public void tesSortColumnsInOrderOfCertainLineElementIncreasingNotMatrix() throws OptionalTask2Exception {
        int[][] matrix = {{-5, 14, 9}, {-2, 17}};
        operator.sortColumnsInOrderOfCertainLineElementIncreasing(matrix, 0);
    }

    @Test(expected = OptionalTask2Exception.class)
    public void testSortColumnsInOrderOfCertainLineElementIncreasingExceedLineIndex() throws OptionalTask2Exception {
        int[][] matrix = {{-5, 14}, {-2, 17}};
        operator.sortColumnsInOrderOfCertainLineElementIncreasing(matrix, 2);
    }

    @Test
    public void testFormSquareMatrixAndFillWithRandomNumbers() throws OptionalTask2Exception {
        int[][] squareMatrix = operator.formSquareMatrixAndFillWithRandomNumbers(4, 30);
        int rowsNumber = squareMatrix.length;
        int elementsInFirstRow = squareMatrix[0].length;
        Assert.assertEquals(rowsNumber, elementsInFirstRow);
    }

    @Test
    public void testFormSquareMatrixAndFillWithRandomNumberZeroSizeAsParameter() throws OptionalTask2Exception {
        int expected = 0;
        int actual = operator.formSquareMatrixAndFillWithRandomNumbers(0, 30).length;
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = OptionalTask2Exception.class)
    public void testFormSquareMatrixAndFillWithRandomNumbersNegativeSizeAsParameter() throws OptionalTask2Exception {
        operator.formSquareMatrixAndFillWithRandomNumbers(-4, 30);
    }
}


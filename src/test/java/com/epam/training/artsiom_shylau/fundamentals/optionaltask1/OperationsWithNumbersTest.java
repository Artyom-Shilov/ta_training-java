package com.epam.training.artsiom_shylau.fundamentals.optionaltask1;

import com.epam.training.artsiom_shylau.fundamentals.optionaltask1.exception.OperationsWithNumbersException;
import com.epam.training.artsiom_shylau.fundamentals.optionaltask1.util.OperationsWithNumbers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OperationsWithNumbersTest {

    private OperationsWithNumbers numbersOperator;

    @Before
    public void setUp() {
        numbersOperator = new OperationsWithNumbers();
    }

    @Test
    public void testFindShortestNumberAndItsLengthSingleShortestNumber() throws OperationsWithNumbersException {
        int[] array = {555, 355636, -2343242, 222, -45, 989};
        Assert.assertArrayEquals(new int[]{-45, 2}, numbersOperator.findShortestNumberAndItsLength(array));
    }

    @Test
    public void testFindShortestNumberAndItsLengthSeveralShortestNumbers() throws OperationsWithNumbersException {
        int[] array = {555, 355636, 2343242, 4, 222, 45, 989, 5, 8};
        Assert.assertArrayEquals(new int[]{4, 1}, numbersOperator.findShortestNumberAndItsLength(array));
    }

    @Test
    public void testFindShortestNumberAndItsLengthOnlyOneElement() throws OperationsWithNumbersException {
        int[] array = {0};
        Assert.assertArrayEquals(new int[]{0, 1}, numbersOperator.findShortestNumberAndItsLength(array));
    }

    @Test(expected = OperationsWithNumbersException.class)
    public void testFindShortestNumberAndItsLengthNullAsParameter() throws OperationsWithNumbersException {
        numbersOperator.findShortestNumberAndItsLength(null);
    }

    @Test(expected = OperationsWithNumbersException.class)
    public void testFindShortestNumberAndItsLengthZeroLengthArrayAsParameter() throws OperationsWithNumbersException {
        numbersOperator.findShortestNumberAndItsLength(new int[0]);
    }

    @Test
    public void testFindLongestNumberAndItsLengthSingleLongestNumber() throws OperationsWithNumbersException {
        int[] array = {555, 355636, 2343, 222, 45, 989};
        Assert.assertArrayEquals(new int[]{355636, 6}, numbersOperator.findLongestNumberAndItsLength(array));
    }

    @Test
    public void testFindLongestNumberAndItsLengthSeveralLongestNumbers() throws OperationsWithNumbersException {
        int[] array = {555, 35, 23435, 4, 22255, 45, 98900, 5, 8};
        Assert.assertArrayEquals(new int[]{23435, 5}, numbersOperator.findLongestNumberAndItsLength(array));
    }

    @Test
    public void testFindLongestNumberAndItsLengthOnlyOneElement() throws OperationsWithNumbersException {
        int[] array = {0};
        Assert.assertArrayEquals(new int[]{0, 1}, numbersOperator.findLongestNumberAndItsLength(array));
    }

    @Test(expected = OperationsWithNumbersException.class)
    public void testFindLongestNumberAndItsLengthNullAsParameter() throws OperationsWithNumbersException {
        numbersOperator.findLongestNumberAndItsLength(null);
    }

    @Test(expected = OperationsWithNumbersException.class)
    public void testFindLongestNumberAndItsLengthZeroLengthArrayAsParameter() throws OperationsWithNumbersException {
        numbersOperator.findLongestNumberAndItsLength(new int[0]);
    }

    @Test
    public void sortNumbersInLengthIncreasingOrder() throws OperationsWithNumbersException {
        int[] array = {555, 355636, 2343242, 4, -222, 45, 989, 5, 8};
        numbersOperator.sortNumbersInLengthIncreasingOrder(array);
        Assert.assertArrayEquals(new int[]{4, 5, 8, 45, 555, -222, 989, 355636, 2343242}, array);
    }

    @Test
    public void sortNumbersInLengthIncreasingOrderOnlyOneElement() throws OperationsWithNumbersException {
        int[] array = {56};
        numbersOperator.sortNumbersInLengthIncreasingOrder(array);
        Assert.assertArrayEquals(new int[]{56}, array);
    }

    @Test(expected = OperationsWithNumbersException.class)
    public void sortNumbersInLengthIncreasingOrderNullAsParameter() throws OperationsWithNumbersException {
        numbersOperator.sortNumbersInLengthIncreasingOrder(null);
    }

    @Test(expected = OperationsWithNumbersException.class)
    public void sortNumbersInLengthIncreasingOrderZeroLengthArrayAsParameter() throws OperationsWithNumbersException {
        numbersOperator.sortNumbersInLengthIncreasingOrder(new int[0]);
    }

    @Test
    public void testFindFirstNumberWithMinimumAmountOfUniqueDigitsSameDigitsNumbers()
                                                                                throws OperationsWithNumbersException {
        int[] array = {345, 655, 765, 877, 333};
        Assert.assertEquals(333, numbersOperator.findFirstNumberWithMinimumAmountOfUniqueDigits(array));
    }

    @Test
    public void testFindFirstNumberWithMinimumAmountOfUniqueDigitsDifferentDigitsNumbers()
                                                                                throws OperationsWithNumbersException {
        int[] array = {345, 655, 765, 877, 2, 222, 22};
        Assert.assertEquals(2, numbersOperator.findFirstNumberWithMinimumAmountOfUniqueDigits(array));
    }

    @Test(expected = OperationsWithNumbersException.class)
    public void testFindFirstNumberWithMinimumAmountOfUniqueDigitsNullAsParameter()
                                                                                throws OperationsWithNumbersException {
        numbersOperator.findFirstNumberWithMinimumAmountOfUniqueDigits(null);
    }

    @Test(expected = OperationsWithNumbersException.class)
    public void testFindFirstNumberWithMinimumAmountOfUniqueZeroLengthArrayAsParameter()
                                                                                throws OperationsWithNumbersException {
        numbersOperator.findFirstNumberWithMinimumAmountOfUniqueDigits(new int[0]);
    }

    @Test
    public void testFindNumbersWithLengthLessThanAverage() throws OperationsWithNumbersException {
        int[] array = {455, 333, 222, 22, 456, 1, 345};
        Assert.assertArrayEquals(new int[]{22, 1}, numbersOperator.findNumbersWithLengthLessThanAverage(array));
    }

    @Test(expected = OperationsWithNumbersException.class)
    public void testFindNumbersWithLengthLessThanAverageZeroLengthArrayAsParameter()
                                                                                throws OperationsWithNumbersException {
        numbersOperator.findNumbersWithLengthLessThanAverage(new int[0]);
    }

    @Test(expected = OperationsWithNumbersException.class)
    public void testFindNumbersWithLengthLessThanAverageNullAsParameter() throws OperationsWithNumbersException {
        numbersOperator.findNumbersWithLengthLessThanAverage(null);
    }
}

package com.epam.training.artsiom_shylau.fundamentals.optional_task1;

import com.epam.training.artsiom_shylau.fundamentals.optional_task1.exception.OptionalTask1Exception;
import com.epam.training.artsiom_shylau.fundamentals.optional_task1.util.FilterOfNumbers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FilterOfNumbersTest {

    private FilterOfNumbers filter;

    @Before
    public void setUp() {
        filter = new FilterOfNumbers();
    }

    @Test
    public void testFindShortestNumberAndItsLengthSingleShortestNumber() throws OptionalTask1Exception {
        int[] array = {555, 355636, -2343242, 222, -45, 989};
        int[] expected = {-45, 2};
        int[] actual = filter.findShortestNumberAndItsLength(array);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindShortestNumberAndItsLengthSeveralShortestNumbers() throws OptionalTask1Exception {
        int[] array = {555, 355636, 2343242, 4, 222, 45, 989, 5, 8};
        int[] expected = {4, 1};
        int[] actual = filter.findShortestNumberAndItsLength(array);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindShortestNumberAndItsLengthOnlyOneElement() throws OptionalTask1Exception {
        int[] array = {0};
        int[] expected = {0, 1};
        int[] actual = filter.findShortestNumberAndItsLength(array);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test(expected = OptionalTask1Exception.class)
    public void testFindShortestNumberAndItsLengthNullAsParameter() throws OptionalTask1Exception {
        filter.findShortestNumberAndItsLength(null);
    }

    @Test(expected = OptionalTask1Exception.class)
    public void testFindShortestNumberAndItsLengthZeroLengthArrayAsParameter() throws OptionalTask1Exception {
        filter.findShortestNumberAndItsLength(new int[0]);
    }

    @Test
    public void testFindLongestNumberAndItsLengthSingleLongestNumber() throws OptionalTask1Exception {
        int[] array = {555, 355636, 2343, 222, 45, 989};
        int[] expected = {355636, 6};
        int[] actual = filter.findLongestNumberAndItsLength(array);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLongestNumberAndItsLengthSeveralLongestNumbers() throws OptionalTask1Exception {
        int[] array = {555, 35, 23435, 4, 22255, 45, 98900, 5, 8};
        int[] expected = {23435, 5};
        int[] actual = filter.findLongestNumberAndItsLength(array);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLongestNumberAndItsLengthOnlyOneElement() throws OptionalTask1Exception {
        int[] array = {0};
        int[] expected = {0, 1};
        int[] actual = filter.findLongestNumberAndItsLength(array);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test(expected = OptionalTask1Exception.class)
    public void testFindLongestNumberAndItsLengthNullAsParameter() throws OptionalTask1Exception {
        filter.findLongestNumberAndItsLength(null);
    }

    @Test(expected = OptionalTask1Exception.class)
    public void testFindLongestNumberAndItsLengthZeroLengthArrayAsParameter() throws OptionalTask1Exception {
        filter.findLongestNumberAndItsLength(new int[0]);
    }

    @Test
    public void sortNumbersInLengthIncreasingOrder() throws OptionalTask1Exception {
        int[] array = {555, 355636, 2343242, 4, -222, 45, 989, 5, 8};
        int[] expected = {4, 5, 8, 45, 555, -222, 989, 355636, 2343242};
        filter.sortNumbersInLengthIncreasingOrder(array);
        Assert.assertArrayEquals(expected, array);
    }

    @Test
    public void sortNumbersInLengthIncreasingOrderOnlyOneElement() throws OptionalTask1Exception {
        int[] array = {56};
        int[] expected = {56};
        filter.sortNumbersInLengthIncreasingOrder(array);
        Assert.assertArrayEquals(expected, array);
    }

    @Test(expected = OptionalTask1Exception.class)
    public void sortNumbersInLengthIncreasingOrderNullAsParameter() throws OptionalTask1Exception {
        filter.sortNumbersInLengthIncreasingOrder(null);
    }

    @Test(expected = OptionalTask1Exception.class)
    public void sortNumbersInLengthIncreasingOrderZeroLengthArrayAsParameter() throws OptionalTask1Exception {
        filter.sortNumbersInLengthIncreasingOrder(new int[0]);
    }

    @Test
    public void testFindFirstNumberWithMinimumAmountOfUniqueDigitsSameDigitsNumbers() throws OptionalTask1Exception {
        int[] array = {345, 655, 765, 877, 333};
        int expected = 333;
        int actual = filter.findFirstNumberWithMinimumAmountOfUniqueDigits(array);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindFirstNumberWithMinimumAmountOfUniqueDigitsDifferentDigitsNumbers() throws OptionalTask1Exception {
        int[] array = {345, 655, 765, 877, 2, 222, 22};
        int expected = 2;
        int actual = filter.findFirstNumberWithMinimumAmountOfUniqueDigits(array);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = OptionalTask1Exception.class)
    public void testFindFirstNumberWithMinimumAmountOfUniqueDigitsNullAsParameter() throws OptionalTask1Exception {
        filter.findFirstNumberWithMinimumAmountOfUniqueDigits(null);
    }

    @Test(expected = OptionalTask1Exception.class)
    public void testFindFirstNumberWithMinimumAmountOfUniqueZeroLengthArrayAsParameter() throws OptionalTask1Exception {
        filter.findFirstNumberWithMinimumAmountOfUniqueDigits(new int[0]);
    }

    @Test
    public void testFindNumbersWithLengthLessThanAverage() throws OptionalTask1Exception {
        int[] array = {455, 333, 222, 22, 456, 1, 345};
        int[] expected = {22, 1};
        int[] actual = filter.findNumbersWithLengthLessThanAverage(array);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test(expected = OptionalTask1Exception.class)
    public void testFindNumbersWithLengthLessThanAverageZeroLengthArrayAsParameter() throws OptionalTask1Exception {
        filter.findNumbersWithLengthLessThanAverage(new int[0]);
    }

    @Test(expected = OptionalTask1Exception.class)
    public void testFindNumbersWithLengthLessThanAverageNullAsParameter() throws OptionalTask1Exception {
        filter.findNumbersWithLengthLessThanAverage(null);
    }
}

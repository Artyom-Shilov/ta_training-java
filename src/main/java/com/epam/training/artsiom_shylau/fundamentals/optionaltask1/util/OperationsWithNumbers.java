package com.epam.training.artsiom_shylau.fundamentals.optionaltask1.util;

import com.epam.training.artsiom_shylau.fundamentals.optionaltask1.exception.OperationsWithNumbersException;
import com.epam.training.artsiom_shylau.fundamentals.optionaltask1.validation.ValidatorOperationsWithNumbers;
import java.util.ArrayList;
import java.util.List;

public class OperationsWithNumbers {

    private int findAmountOfDigitsInNumber(int number) {
        int amountOfDigits = 0;
        do {
            number /= 10;
            amountOfDigits++;
        }
        while (number != 0);
        return amountOfDigits;
    }

    private int[] numberAndItsLength = new int[2];

    public int[] findShortestNumberAndItsLength(int[] array) throws OperationsWithNumbersException {
        ValidatorOperationsWithNumbers.validateArray(array);
        if (array.length == 1) {
            numberAndItsLength[0] = array[0];
            numberAndItsLength[1] = findAmountOfDigitsInNumber(array[0]);
            return numberAndItsLength;
        }
        int shortestNumber = array[0];
        for (int i = 1; i < array.length; i++) {
            if (findAmountOfDigitsInNumber(array[i]) < findAmountOfDigitsInNumber(shortestNumber)) {
                shortestNumber = array[i];
            }
        }
        numberAndItsLength[0] = shortestNumber;
        numberAndItsLength[1] = findAmountOfDigitsInNumber(shortestNumber);
        return numberAndItsLength;
    }

    public int[] findLongestNumberAndItsLength(int[] array) throws OperationsWithNumbersException {
        ValidatorOperationsWithNumbers.validateArray(array);
        if (array.length == 1) {
            numberAndItsLength[0] = array[0];
            numberAndItsLength[1] = findAmountOfDigitsInNumber(array[0]);
            return numberAndItsLength;
        }
        int longestNumber = array[0];
        for (int i = 1; i < array.length; i++) {
            if (findAmountOfDigitsInNumber(array[i]) > findAmountOfDigitsInNumber(longestNumber)) {
                longestNumber = array[i];
            }
        }
        numberAndItsLength[0] = longestNumber;
        numberAndItsLength[1] = findAmountOfDigitsInNumber(longestNumber);
        return numberAndItsLength;
    }

    public void sortNumbersInLengthIncreasingOrder(int[] array) throws OperationsWithNumbersException {
        ValidatorOperationsWithNumbers.validateArray(array);
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (findAmountOfDigitsInNumber(array[j]) > findAmountOfDigitsInNumber(array[j + 1])) {
                    int c = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = c;
                }
            }
        }
    }

    public double findAverageLengthOfElements(int[] array) throws OperationsWithNumbersException {
        ValidatorOperationsWithNumbers.validateArray(array);
        int sumLength = 0;
        for (int element : array) {
            sumLength += findAmountOfDigitsInNumber(element);
        }
        return (double) sumLength / array.length;
    }

    public int[] findNumbersWithLengthLessThanAverage(int[] array) throws OperationsWithNumbersException {
        double averageLength = findAverageLengthOfElements(array);
        List<Integer> numbersWithLengthLessThanAverage = new ArrayList<>();
        for (int element : array) {
            if ((double) findAmountOfDigitsInNumber(element) < averageLength) {
                numbersWithLengthLessThanAverage.add(element);
            }
        }
        return numbersWithLengthLessThanAverage.stream().mapToInt(Integer::intValue).toArray();
    }

    private int findAmountOfUniqueDigitsInNumber(int number) {
        int amountOfUniqueDigits = 0;
        List<Integer> digitsOfNumber = new ArrayList<>();
        do {
            int lastDigitOfNumber = number % 10;
            if (!digitsOfNumber.contains(lastDigitOfNumber)) {
                amountOfUniqueDigits++;
                digitsOfNumber.add(lastDigitOfNumber);
            }
            number /= 10;
        } while (number != 0);
        return amountOfUniqueDigits;
    }

    public int findFirstNumberWithMinimumAmountOfUniqueDigits(int[] array) throws OperationsWithNumbersException {
        ValidatorOperationsWithNumbers.validateArray(array);
        if (array.length == 1) {
            return array[0];
        }
        int numberWithMinimumAmount = array[0];
        for (int i = 1; i < array.length; i++) {
            if (findAmountOfUniqueDigitsInNumber(array[i])
                    < findAmountOfUniqueDigitsInNumber(numberWithMinimumAmount)) {
                numberWithMinimumAmount = array[i];
            }
        }
        return numberWithMinimumAmount;
    }
}
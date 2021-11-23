package com.epam.training.artsiom_shylau.fundamentals.optional_task1.launch;

import com.epam.training.artsiom_shylau.fundamentals.optional_task1.util.FilterOfNumbers;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        try {
            int[] array = {555, 355636, -2343242, 222, -45, 989, 0, -2344, 675, 66};
            System.out.println("Numbers: ");
            System.out.println(Arrays.toString(array));
            FilterOfNumbers filter = new FilterOfNumbers();
            System.out.println("The longest number and its length:");
            System.out.println(Arrays.toString(filter.findLongestNumberAndItsLength(array)));
            System.out.println("The shortest number and its length: ");
            System.out.println(Arrays.toString(filter.findShortestNumberAndItsLength(array)));
            System.out.println("Average length of numbers: ");
            System.out.println(filter.findAverageLengthOfElements(array));
            System.out.println("Numbers with length less than average: ");
            System.out.println(Arrays.toString(filter.findNumbersWithLengthLessThanAverage(array)));
            System.out.println("The first number with minimum amount of unique digits: ");
            System.out.println(filter.findFirstNumberWithMinimumAmountOfUniqueDigits(array));
            System.out.println("Sorted numbers in order of their length increasing: ");
            filter.sortNumbersInLengthIncreasingOrder(array);
            System.out.println(Arrays.toString(array));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.epam.training.artsiom_shylau.fundamentals.optionaltask1.launch;

import com.epam.training.artsiom_shylau.fundamentals.optionaltask1.util.OperationsWithNumbers;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

public class Runner {

    private static Logger logger = Logger.getLogger(Runner.class);
    private static int[] array  = {555, 355636, -2343242, 222, -45, 989, 0, -2344, 675, 66};

    public static void main(String[] args) {
        try {
            logger.log(Level.INFO, "Initial array: " + Arrays.toString(array));
            OperationsWithNumbers numbersOperator = new OperationsWithNumbers();
            logger.log(Level.INFO, "The longest number and its length: "
                    + Arrays.toString(numbersOperator.findLongestNumberAndItsLength(array)));
            logger.log(Level.INFO, "The shortest number and its length: "
                    + Arrays.toString(numbersOperator.findShortestNumberAndItsLength(array)));
            logger.log(Level.INFO, "Average length of numbers: "
                    + numbersOperator.findAverageLengthOfElements(array));
            logger.log(Level.INFO, "Numbers with length less than average: "
                    + Arrays.toString(numbersOperator.findNumbersWithLengthLessThanAverage(array)));
            logger.log(Level.INFO, "The first number with minimum amount of unique digits: "
                    + numbersOperator.findFirstNumberWithMinimumAmountOfUniqueDigits(array));
            numbersOperator.sortNumbersInLengthIncreasingOrder(array);
            logger.log(Level.INFO, "Sorted numbers in order of their length increasing: "
                    + Arrays.toString(array));
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            logger.log(Level.ERROR, stringWriter.toString());
        }
    }
}

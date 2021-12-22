package com.epam.training.artsiom_shylau.fundamentals.maintask.launch;

import com.epam.training.artsiom_shylau.fundamentals.maintask.util.ConsoleOperations;
import com.epam.training.artsiom_shylau.fundamentals.maintask.exception.ConsoleOperationsException;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) {
        try {
            System.out.println("1 - Greet User Named By Command Line \n" +
                    "2 - Print Command Line Arguments In Reverse Order In Console \n" +
                    "3 - Print Random Numbers From 0 To 100 In Console Without Line Wrapping \n" +
                    "4 - Print Random Numbers From 0 To 100 In Console With Line Wrapping \n" +
                    "5 - Print Sum Of Command Line Arguments In Console\n" +
                    "6 - Print Multiplication Of Command Line Arguments In Console\n" +
                    "7 - Print Month Name By It's Number In Console\n");
            System.out.println("Enter number of operation: ");
            ConsoleOperations consoleOperations = new ConsoleOperations();
            int numberOfOperation = consoleOperations.readIntegerNumberFromConsole();
            switch (numberOfOperation) {
                case 1:
                    consoleOperations.greetUserNamedByCommandLineInConsole(args);
                    break;
                case 2:
                    consoleOperations.printCommandLineArgumentsInReverseOrderInConsole(args);
                    break;
                case 3:
                    System.out.println("Enter amount of numbers for output in console:");
                    consoleOperations.printCertainAmountOfRandomNumbersFrom0To100InConsoleWithoutLineWrapping(
                            consoleOperations.readIntegerNumberFromConsole());
                    break;
                case 4:
                    System.out.println("Enter amount of numbers for output in console:");
                    consoleOperations.printCertainAmountOfRandomNumbersFrom0To100InConsoleWithLineWrapping(
                            consoleOperations.readIntegerNumberFromConsole());
                    break;
                case 5:
                    consoleOperations.printSumOfCommandLineArgumentsInConsole(args);
                    break;
                case 6:
                    consoleOperations.printMultiplicationOfCommandLineArgumentsInConsole(args);
                    break;
                case 7:
                    System.out.println("Enter number of month:");
                    consoleOperations.printMonthNameByItsNumberInConsole(
                            consoleOperations.readIntegerNumberFromConsole());
                    break;
                default:
                    System.out.println("There is no operations with such number!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

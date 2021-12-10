package com.epam.training.artsiom_shylau.fundamentals.maintask.util;

import com.epam.training.artsiom_shylau.fundamentals.maintask.exception.ConsoleOperationsException;
import com.epam.training.artsiom_shylau.fundamentals.maintask.validation.ConsoleOperationsValidator;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleOperations {

    public void greetUserNamedByCommandLineInConsole(String[] args) throws ConsoleOperationsException {
        if (args == null) {
            throw new ConsoleOperationsException("argument is null");
        }
        if (args.length != 2) {
            throw new ConsoleOperationsException("Must be name and surname as command line parameters");
        }
        System.out.println("Hello " + args[0] + " " + args[1] +  "!");
    }

    public void printCommandLineArgumentsInReverseOrderInConsole(String[] arguments) throws ConsoleOperationsException {
        ConsoleOperationsValidator.validateArray(arguments);
        String[] arrayWithArgumentsInReverseOrder = new String[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            arrayWithArgumentsInReverseOrder[i] = arguments[arguments.length - 1 - i];
        }
        for (String string : arrayWithArgumentsInReverseOrder) {
            System.out.print(string + " ");
        }
    }

    private int[] getArrayOfOfRandomNumbersFrom0To100WithCertainLength(int length) throws ConsoleOperationsException{
        if (length <= 0) {
            throw new ConsoleOperationsException("argument must be positive");
        }
        int[] randomNumbers0to100Array = new int[length];
        for (int i = 0; i < length; i++) {
            randomNumbers0to100Array[i] = (int) (Math.random() * 100 + 1);
        }
        return randomNumbers0to100Array;
    }

    public void printCertainAmountOfRandomNumbersFrom0To100InConsoleWithLineWrapping(int amountOfNumbers)
                                                                                    throws ConsoleOperationsException {
        int[] randomNumbers0to100Array = getArrayOfOfRandomNumbersFrom0To100WithCertainLength(amountOfNumbers);
        for (int i : randomNumbers0to100Array) {
            System.out.println(i);
        }
    }

    public void printCertainAmountOfRandomNumbersFrom0To100InConsoleWithoutLineWrapping(int amountOfNumbers)
                                                                                    throws ConsoleOperationsException {
        int[] randomNumbers0to100Array = getArrayOfOfRandomNumbersFrom0To100WithCertainLength(amountOfNumbers);
        for (int i : randomNumbers0to100Array) {
            System.out.print(i + " ");
        }
    }

    public void printSumOfCommandLineArgumentsInConsole(String[] args) throws ConsoleOperationsException {
        ConsoleOperationsValidator.validateArray(args);
        double sum = 0;
        try {
            for (String arg : args) {
                sum += Double.parseDouble(arg);
            }
        } catch (NumberFormatException e) {
            throw new ConsoleOperationsException(e.getMessage(), e);
        }
        System.out.println(sum);
    }

    public void printMultiplicationOfCommandLineArgumentsInConsole(String[] args) throws ConsoleOperationsException {
        ConsoleOperationsValidator.validateArray(args);
        double multiplication = 1;
        try {
            for (String arg : args) {
                multiplication *= Double.parseDouble(arg);
            }
        } catch (NumberFormatException e) {
            throw new ConsoleOperationsException(e.getMessage(), e);
        }
        System.out.println(multiplication);
    }

    public void printMonthNameByItsNumberInConsole(int monthNumber) throws ConsoleOperationsException {
        switch (monthNumber) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                throw new ConsoleOperationsException("there is no month with such number");
        }
    }

    public int readIntegerNumberFromConsole() throws ConsoleOperationsException {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            throw new ConsoleOperationsException("Integer number input: wrong number format");
        }
    }


}

package com.epam.training.artsiom_shylau.fundamentals.input;

import com.epam.training.artsiom_shylau.fundamentals.input.exception.DataInputFromConsoleException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DataInputFromConsole {

    private static Scanner scanner = new Scanner(System.in);

    public static String enterStringType(){
        return scanner.nextLine();
    }

    public static int enterIntType() throws DataInputFromConsoleException {
        int number = 0;
        try {
            number = scanner.nextInt();
        } catch (Exception e) {
            throw new DataInputFromConsoleException("wrong number format");
        } finally {
            scanner.nextLine();
        }
        return number;
    }
}

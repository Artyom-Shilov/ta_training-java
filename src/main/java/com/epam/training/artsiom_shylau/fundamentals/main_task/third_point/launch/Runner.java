package com.epam.training.artsiom_shylau.fundamentals.main_task.third_point.launch;

import com.epam.training.artsiom_shylau.fundamentals.input.DataInputFromConsole;
import com.epam.training.artsiom_shylau.fundamentals.input.exception.DataInputFromConsoleException;
import com.epam.training.artsiom_shylau.fundamentals.main_task.third_point.util.OutputOfNumbers;

public class Runner {

    public static void main(String[] args) {
        System.out.println("enter amount of random numbers: ");
        try {
            int amount = DataInputFromConsole.enterIntType();
            OutputOfNumbers outputOfNumbers = new OutputOfNumbers();
            for (int i = 0; i < amount; i++) {
                System.out.println(outputOfNumbers.getArrayOfRandomNumbersFrom0To100(amount)[i]);
            }
            System.out.println();
            for (int i = 0; i < amount; i++) {
                System.out.print(outputOfNumbers.getArrayOfRandomNumbersFrom0To100(amount)[i] + " ");
            }
        } catch (DataInputFromConsoleException e) {
            System.out.println(e.getMessage());
            main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


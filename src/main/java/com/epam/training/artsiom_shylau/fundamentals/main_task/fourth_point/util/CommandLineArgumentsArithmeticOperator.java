package com.epam.training.artsiom_shylau.fundamentals.main_task.fourth_point.util;

import com.epam.training.artsiom_shylau.fundamentals.main_task.exception.MainTaskException;
import com.epam.training.artsiom_shylau.fundamentals.main_task.validation.MainTaskValidator;

public class CommandLineArgumentsArithmeticOperator {

    public int calculateSumOfArguments(String[] args) throws MainTaskException {
        MainTaskValidator.validateArray(args);
        int sum = 0;
        try {
            for (String arg : args) {
                sum += Integer.parseInt(arg);
            }
        } catch (NumberFormatException e) {
            throw new MainTaskException(e.getMessage(), e);
        }
        return sum;
    }

    public int calculateMultiplicationOfArguments(String[] args) throws MainTaskException {
        MainTaskValidator.validateArray(args);
        int multiplication = 1;
        try {
            for (String arg : args) {
                multiplication *= Integer.parseInt(arg);
            }
        } catch (NumberFormatException e) {
            throw new MainTaskException(e.getMessage(), e);
        }
        return multiplication;
    }
}

package com.epam.training.artsiom_shylau.fundamentals.main_task.second_point.util;

import com.epam.training.artsiom_shylau.fundamentals.main_task.exception.MainTaskException;
import com.epam.training.artsiom_shylau.fundamentals.main_task.validation.MainTaskValidator;

public class CommandLineArgumentsProcessor {

    public String[] getArgumentsInReverseOrder(String[] arguments) throws MainTaskException {
        MainTaskValidator.validateArray(arguments);
        String[] arrayWithArgumentsInReverseOrder = new String[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            arrayWithArgumentsInReverseOrder[i] = arguments[arguments.length - 1 - i];
        }
        return arrayWithArgumentsInReverseOrder;
    }
}



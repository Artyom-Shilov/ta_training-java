package com.epam.training.artsiom_shylau.fundamentals.main_task.first_point.util;

import com.epam.training.artsiom_shylau.fundamentals.main_task.exception.MainTaskException;

public class Greeter {

    public static String getGreetingForUserNamedByCommandLine(String[] args) throws MainTaskException {
        if (args == null) {
            throw new MainTaskException("argument is null");
        }
        if (args.length != 2) {
            throw new MainTaskException("Must be name and surname as command line parameters");
        }
        return "Hello " + args[0] + " " + args[1];
    }
}

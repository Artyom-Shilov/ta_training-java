package com.epam.training.artsiom_shylau.fundamentals.main_task.first_point.launch;

import com.epam.training.artsiom_shylau.fundamentals.main_task.first_point.util.Greeter;

public class Runner {

    public static void main(String[] args) {
        try {
            System.out.println(Greeter.getGreetingForUserNamedByCommandLine(args));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

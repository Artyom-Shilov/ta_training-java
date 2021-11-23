package com.epam.training.artsiom_shylau.fundamentals.main_task.second_point.launch;

import com.epam.training.artsiom_shylau.fundamentals.main_task.second_point.util.CommandLineArgumentsProcessor;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
        try {
            System.out.println(Arrays.toString(new CommandLineArgumentsProcessor().getArgumentsInReverseOrder(args)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

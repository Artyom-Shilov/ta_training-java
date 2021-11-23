package com.epam.training.artsiom_shylau.fundamentals.main_task.fourth_point.launch;

import com.epam.training.artsiom_shylau.fundamentals.main_task.fourth_point.util.CommandLineArgumentsArithmeticOperator;

public class Runner {

    public static void main(String[] args) {
        try {
            CommandLineArgumentsArithmeticOperator arithmeticOperator = new CommandLineArgumentsArithmeticOperator();
            System.out.println(arithmeticOperator.calculateMultiplicationOfArguments(args));
            System.out.println(arithmeticOperator.calculateSumOfArguments(args));
        } catch (Exception e){
           e.printStackTrace();
        }
    }
}

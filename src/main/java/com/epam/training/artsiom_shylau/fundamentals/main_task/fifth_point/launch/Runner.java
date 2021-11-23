package com.epam.training.artsiom_shylau.fundamentals.main_task.fifth_point.launch;

import com.epam.training.artsiom_shylau.fundamentals.input.DataInputFromConsole;
import com.epam.training.artsiom_shylau.fundamentals.input.exception.DataInputFromConsoleException;
import com.epam.training.artsiom_shylau.fundamentals.main_task.fifth_point.util.MonthResolver;

public class Runner {

    public static void main(String[] args) {
        try {
            System.out.println("enter number of month");
            System.out.println(new MonthResolver().getMonthNameByItsNumber(DataInputFromConsole.enterIntType()));
        } catch (DataInputFromConsoleException e) {
            System.out.println(e.getMessage());
            main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

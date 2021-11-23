package com.epam.training.artsiom_shylau.fundamentals.main_task.fifth_point.util;

import com.epam.training.artsiom_shylau.fundamentals.main_task.exception.MainTaskException;

public class MonthResolver {

    public String getMonthNameByItsNumber (int monthNumber) throws MainTaskException {
        switch (monthNumber) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                throw new MainTaskException("there is no month with such number");
        }
    }
}

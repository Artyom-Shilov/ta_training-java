package com.epam.training.artsiom_shylau.fundamentals.main_task;

import com.epam.training.artsiom_shylau.fundamentals.main_task.exception.MainTaskException;
import com.epam.training.artsiom_shylau.fundamentals.main_task.fifth_point.util.MonthResolver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FifthPointTest {

    private MonthResolver monthResolver;

    @Before
    public void setUp() {
        monthResolver = new MonthResolver();
    }

    @Test
    public void testGetMonthNameByItsNumberValidMonthNumber() throws MainTaskException {
        String expected = "March";
        String actual = monthResolver.getMonthNameByItsNumber(3);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = MainTaskException.class)
    public void testGetMonthNameByItsNumberMoreThan12() throws MainTaskException {
        monthResolver.getMonthNameByItsNumber(20);
    }

    @Test(expected = MainTaskException.class)
    public void testGetMonthNameByItsNumberLessThan1() throws MainTaskException {
        monthResolver.getMonthNameByItsNumber(-1);
    }

}



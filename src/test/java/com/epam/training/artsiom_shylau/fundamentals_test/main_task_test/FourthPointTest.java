package com.epam.training.artsiom_shylau.fundamentals_test.main_task_test;

import com.epam.training.artsiom_shylau.fundamentals.main_task.exception.MainTaskException;
import com.epam.training.artsiom_shylau.fundamentals.main_task.fourth_point.util.CommandLineArgumentsArithmeticOperator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FourthPointTest {

    private CommandLineArgumentsArithmeticOperator arithmeticOperator;

    @Before
    public void setUp() {
        arithmeticOperator = new CommandLineArgumentsArithmeticOperator();
    }

    @Test
    public void testCalculateSumOfArguments() throws MainTaskException {
        int actual = arithmeticOperator.calculateSumOfArguments(new String[]{"12", "40", "0", "67", "-3"});
        int expected = 116;
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = MainTaskException.class)
    public void testCalculateSumOfArgumentsZeroLength() throws MainTaskException {
        arithmeticOperator.calculateSumOfArguments(new String[0]);
    }

    @Test(expected = MainTaskException.class)
    public void testCalculateSumOfArgumentsNull() throws MainTaskException {
        arithmeticOperator.calculateSumOfArguments(null);
    }

    @Test(expected = MainTaskException.class)
    public void testCalculateSumOfArgumentsLetters() throws MainTaskException {
        arithmeticOperator.calculateSumOfArguments(new String[]{"string", "40", "0", "67", "-3"});
    }

    @Test(expected = MainTaskException.class)
    public void testCalculateSumOfArgumentsFloatingDot() throws MainTaskException {
        arithmeticOperator.calculateSumOfArguments(new String[]{"44.55", "40", "0", "67", "-3"});
    }

    @Test
    public void testCalculateMultiplicationOfArguments() throws MainTaskException {
        int actual = arithmeticOperator.calculateMultiplicationOfArguments(new String[]{"12", "40", "1", "67", "-3"});
        int expected = -96480;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateMultiplicationOfArgumentsZero() throws MainTaskException {
        int actual = arithmeticOperator.calculateMultiplicationOfArguments(new String[]{"0"});
        int expected = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = MainTaskException.class)
    public void testCalculateMultiplicationOfArgumentsZeroLength() throws MainTaskException {
        arithmeticOperator.calculateMultiplicationOfArguments(new String[0]);
    }

    @Test(expected = MainTaskException.class)
    public void testCalculateMultiplicationOfArgumentsNull() throws MainTaskException {
        arithmeticOperator.calculateMultiplicationOfArguments(null);
    }

    @Test(expected = MainTaskException.class)
    public void testCalculateMultiplicationOfArgumentsLetters() throws MainTaskException {
        arithmeticOperator.calculateMultiplicationOfArguments(new String[]{"string", "40", "0", "67", "-3"});
    }

    @Test(expected = MainTaskException.class)
    public void testCalculateMultiplicationOfArgumentsFloatingDot() throws MainTaskException {
        arithmeticOperator.calculateMultiplicationOfArguments(new String[]{"44.55", "40", "0", "67", "-3"});
    }
}

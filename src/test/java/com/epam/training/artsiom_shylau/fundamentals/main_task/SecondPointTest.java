package com.epam.training.artsiom_shylau.fundamentals.main_task;

import com.epam.training.artsiom_shylau.fundamentals.main_task.exception.MainTaskException;
import com.epam.training.artsiom_shylau.fundamentals.main_task.second_point.util.CommandLineArgumentsProcessor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SecondPointTest {

    private CommandLineArgumentsProcessor processor;

    @Before
    public void setUp() {
        processor = new CommandLineArgumentsProcessor();
    }

    @Test
    public void testDisplayArgumentsInReverseOrder() throws MainTaskException {
        String actual = Arrays.toString(processor.getArgumentsInReverseOrder(new String[]{"1", "2", "3", "4"}));
        String expected = Arrays.toString(new String[]{"4", "3", "2", "1"});
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = MainTaskException.class)
    public void testDisplayArgumentsInReverseOrderZeroLength() throws MainTaskException {
        processor.getArgumentsInReverseOrder(new String[0]);
        processor.getArgumentsInReverseOrder(new String[0]);
    }

    @Test(expected = MainTaskException.class)
    public void testDisplayArgumentsInReverseOrderNull() throws MainTaskException {
        processor.getArgumentsInReverseOrder(null);
    }
}

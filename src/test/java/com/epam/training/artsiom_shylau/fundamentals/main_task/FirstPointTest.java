package com.epam.training.artsiom_shylau.fundamentals.main_task;

import com.epam.training.artsiom_shylau.fundamentals.main_task.exception.MainTaskException;
import com.epam.training.artsiom_shylau.fundamentals.main_task.first_point.util.Greeter;
import org.junit.Assert;
import org.junit.Test;

public class FirstPointTest {

    @Test
    public void testGreetUserNamedByCommandLineTwoParameters() throws MainTaskException {
        String actual = Greeter.getGreetingForUserNamedByCommandLine(new String[]{"Artyom", "Shylov"});
        String expected = "Hello Artyom Shylov";
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = MainTaskException.class)
    public void testGreetUserNamedByCommandLineMoreThanTwoParameters() throws MainTaskException {
        Greeter.getGreetingForUserNamedByCommandLine(new String[]{"Artyom", "Shylov", "Shylov"});
    }

    @Test(expected = MainTaskException.class)
    public void testGreetUserNamedByCommandLineLessThanTwoParameters() throws MainTaskException {
        Greeter.getGreetingForUserNamedByCommandLine(new String[]{});
    }

    @Test(expected = MainTaskException.class)
    public void testGreetUserNamedByCommandLineNullIsReceived() throws MainTaskException {
        Greeter.getGreetingForUserNamedByCommandLine(null);
    }
}

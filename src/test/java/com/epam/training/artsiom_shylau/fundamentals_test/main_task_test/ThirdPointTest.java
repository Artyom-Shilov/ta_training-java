package com.epam.training.artsiom_shylau.fundamentals_test.main_task_test;

import com.epam.training.artsiom_shylau.fundamentals.main_task.exception.MainTaskException;
import com.epam.training.artsiom_shylau.fundamentals.main_task.third_point.util.OutputOfNumbers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class ThirdPointTest {

    private OutputOfNumbers outputOfNumbers;

    @Before
    public void setUp(){
        outputOfNumbers = new OutputOfNumbers();
    }

    @Test
    public void testGetArrayOfRandomNumbersFrom0To100() throws MainTaskException {
        int[] randomArray = outputOfNumbers.getArrayOfRandomNumbersFrom0To100(100);
        Arrays.sort(randomArray);
        Assert.assertTrue(randomArray[0] >= 0 && randomArray[randomArray.length -1] <= 100);
    }

    @Test(expected = MainTaskException.class)
    public void testGetArrayOfRandomNumbersFrom0To100NegativeParameter() throws MainTaskException {
        outputOfNumbers.getArrayOfRandomNumbersFrom0To100(0);
    }

    @Test(expected = MainTaskException.class)
    public void testGetArrayOfRandomNumbersFrom0To100ZeroAsParameter() throws MainTaskException {
        outputOfNumbers.getArrayOfRandomNumbersFrom0To100(0);
    }

}

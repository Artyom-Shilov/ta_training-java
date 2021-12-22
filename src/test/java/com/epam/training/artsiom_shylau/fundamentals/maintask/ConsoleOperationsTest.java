package com.epam.training.artsiom_shylau.fundamentals.maintask;

import com.epam.training.artsiom_shylau.fundamentals.maintask.exception.ConsoleOperationsException;
import com.epam.training.artsiom_shylau.fundamentals.maintask.util.ConsoleOperations;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleOperationsTest {

    private ConsoleOperations consoleOperations;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        consoleOperations = new ConsoleOperations();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testPrintMonthNameByItsNumberInConsoleValidMonthNumber() throws ConsoleOperationsException {
        consoleOperations.printMonthNameByItsNumberInConsole(3);
        Assert.assertEquals("March", outputStreamCaptor.toString().trim());
    }

    @Test(expected = ConsoleOperationsException.class)
    public void testPrintMonthNameByItsNumberInConsoleInvalidMonthNumber() throws ConsoleOperationsException {
        consoleOperations.printMonthNameByItsNumberInConsole(20);
    }

    @Test
    public void testGreetUserNamedByCommandLineInConsoleTwoParameters() throws ConsoleOperationsException {
        consoleOperations.greetUserNamedByCommandLineInConsole(new String[]{"Test", "User"});
        Assert.assertEquals("Hello Test User!", outputStreamCaptor.toString().trim());
    }

    @Test(expected = ConsoleOperationsException.class)
    public void testGreetUserNamedByCommandLineMoreThanTwoParameters() throws ConsoleOperationsException {
        consoleOperations.greetUserNamedByCommandLineInConsole(new String[]{"Test", "User", "Test"});
    }

    @Test(expected = ConsoleOperationsException.class)
    public void testGreetUserNamedByCommandLineLessThanTwoParameters() throws ConsoleOperationsException {
        consoleOperations.greetUserNamedByCommandLineInConsole(new String[]{"Test"});
    }

    @Test(expected = ConsoleOperationsException.class)
    public void testGreetUserNamedByCommandLineNullAsArgument() throws ConsoleOperationsException {
        consoleOperations.greetUserNamedByCommandLineInConsole(null);
    }

    @Test
    public void testPrintCommandLineArgumentsInReverseOrderInConsole() throws ConsoleOperationsException {
        consoleOperations.printCommandLineArgumentsInReverseOrderInConsole(new String[]{"1", "2", "3", "4"});
        Assert.assertEquals("4 3 2 1", outputStreamCaptor.toString().trim());
    }

    @Test(expected = ConsoleOperationsException.class)
    public void testPrintCommandLineArgumentsInReverseOrderInConsoleZeroLengthArray()
                                                                                    throws ConsoleOperationsException {
        consoleOperations.printCommandLineArgumentsInReverseOrderInConsole(new String[0]);
    }

    @Test(expected = ConsoleOperationsException.class)
    public void testDisplayArgumentsInReverseOrderNullAsArgument() throws ConsoleOperationsException {
        consoleOperations.printCommandLineArgumentsInReverseOrderInConsole(null);
    }

    @Test
    public void testPrintCertainAmountOfRandomNumbersFrom0To100InConsoleWithoutLineWrapping()
                                                                                    throws ConsoleOperationsException {
        consoleOperations.printCertainAmountOfRandomNumbersFrom0To100InConsoleWithoutLineWrapping(3);
        Scanner scanner = new Scanner(outputStreamCaptor.toString().trim());
        int firstRandomNumber = scanner.nextInt();
        int secondRandomNumber = scanner.nextInt();
        int thirdRandomNumber =  scanner.nextInt();
        Assert.assertTrue((firstRandomNumber >= 0 && firstRandomNumber <= 100)
                && (secondRandomNumber >= 0 && secondRandomNumber <= 100)
                && (thirdRandomNumber >= 0 && thirdRandomNumber <= 100));
    }

    @Test(expected = ConsoleOperationsException.class)
    public void testPrintCertainAmountOfRandomNumbersFrom0To100InConsoleWithoutLineWrappingNegativeArgument()
                                                                                    throws ConsoleOperationsException {
        consoleOperations.printCertainAmountOfRandomNumbersFrom0To100InConsoleWithoutLineWrapping(-3);
    }

    @Test(expected = ConsoleOperationsException.class)
    public void testPrintCertainAmountOfRandomNumbersFrom0To100InConsoleWithoutLineWrappingZeroAsArgument()
                                                                                    throws ConsoleOperationsException {
        consoleOperations.printCertainAmountOfRandomNumbersFrom0To100InConsoleWithoutLineWrapping(0);
    }

    @Test
    public void testPrintCertainAmountOfRandomNumbersFrom0To100InConsoleWithLineWrapping()
                                                                                    throws ConsoleOperationsException {
        consoleOperations.printCertainAmountOfRandomNumbersFrom0To100InConsoleWithLineWrapping(3);
        Scanner scanner = new Scanner(outputStreamCaptor.toString().trim());
        int firstRandomNumber = scanner.nextInt();
        int secondRandomNumber = scanner.nextInt();
        int thirdRandomNumber =  scanner.nextInt();
        Assert.assertTrue((firstRandomNumber >= 0 && firstRandomNumber <= 100)
                && (secondRandomNumber >= 0 && secondRandomNumber <= 100)
                && (thirdRandomNumber >= 0 && thirdRandomNumber <= 100));
    }

    @Test
    public void testCalculateSumOfArguments() throws ConsoleOperationsException {
        consoleOperations.printSumOfCommandLineArgumentsInConsole(new String[]{"12", "4.2", "0", "67", "-3"});
        Assert.assertEquals(80.2, Double.parseDouble(outputStreamCaptor.toString().trim()), 0.001);
    }

    @Test(expected = ConsoleOperationsException.class)
    public void testCalculateSumOfArgumentsZeroLengthArrayAsParameter() throws ConsoleOperationsException {
        consoleOperations.printSumOfCommandLineArgumentsInConsole(new String[0]);
    }

    @Test(expected = ConsoleOperationsException.class)
    public void testCalculateSumOfArgumentsNullAsParameter() throws ConsoleOperationsException {
        consoleOperations.printSumOfCommandLineArgumentsInConsole(new String[0]);
    }

    @Test(expected = ConsoleOperationsException.class)
    public void testCalculateSumOfArgumentsLettersInArrayArgument() throws ConsoleOperationsException {
        consoleOperations.printSumOfCommandLineArgumentsInConsole(new String[]{"string", "40", "0", "67", "-3"});
    }

    @Test
    public void testCalculateMultiplicationOfArguments() throws ConsoleOperationsException {
        consoleOperations.printMultiplicationOfCommandLineArgumentsInConsole(new String[]{"0.3", "4", "1.45", "-3"});
        Assert.assertEquals(-5.22,  Double.parseDouble(outputStreamCaptor.toString().trim()), 0.001);
    }

    @Test
    public void testCalculateMultiplicationOfArgumentsZeroAsArgument() throws ConsoleOperationsException {
        consoleOperations.printMultiplicationOfCommandLineArgumentsInConsole(new String[]{"0"});
        Assert.assertEquals(0, Double.parseDouble(outputStreamCaptor.toString().trim()), 0.0001);
    }

    @Test(expected = ConsoleOperationsException.class)
    public void testCalculateMultiplicationOfArgumentsZeroLength() throws ConsoleOperationsException {
        consoleOperations.printMultiplicationOfCommandLineArgumentsInConsole(new String[0]);
    }

    @Test(expected = ConsoleOperationsException.class)
    public void testCalculateMultiplicationOfArgumentsNull() throws ConsoleOperationsException {
        consoleOperations.printMultiplicationOfCommandLineArgumentsInConsole(null);
    }

    @Test(expected = ConsoleOperationsException.class)
    public void testCalculateMultiplicationOfArgumentsLetters() throws ConsoleOperationsException {
        consoleOperations.printMultiplicationOfCommandLineArgumentsInConsole(
                new String[]{"string", "40", "0", "67", "-3"});
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }
}

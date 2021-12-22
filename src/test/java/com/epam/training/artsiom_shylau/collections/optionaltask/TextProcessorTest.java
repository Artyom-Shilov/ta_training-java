package com.epam.training.artsiom_shylau.collections.optionaltask;

import com.epam.training.artsiom_shylau.collections.optionaltask.exceptions.TextProcessorException;
import com.epam.training.artsiom_shylau.collections.optionaltask.util.TextProcessor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TextProcessorTest {

    private TextProcessor textProcessor;

    @Before
    public void setUp(){
        textProcessor = new TextProcessor();
    }

    @Test
    public void testGetSortedByLengthLinesFromFile() throws TextProcessorException, IOException {
        Assert.assertEquals(List.of("1", "22", "333", "4444", "55555", "666666"),
                textProcessor.getSortedByLengthLinesFromFile("src/test/java/com/epam/training/artsiom_shylau"
                        + "/collections/optionaltask/testresources/for-get-sorted-by-length-lines.txt"));
    }

    @Test
    public void testGetSortedAlphabeticalLinesFromFile() throws TextProcessorException, IOException {
        Assert.assertEquals(List.of("eighth", "fifth", "first", "fourth", "second", "seventh", "sixth", "third"),
                textProcessor.getSortedAlphabeticalLinesFromFile("src/test/java/com/epam/training/artsiom_shylau"
                        + "/collections/optionaltask/testresources/for-get-sorted-alphabetical-lines.txt"));
    }

    @Test
    public void testGetSortedAlphabeticalLinesFromFileEmptyFile() throws TextProcessorException, IOException {
        Assert.assertEquals(new ArrayList<>(),
                textProcessor.getSortedAlphabeticalLinesFromFile("src/test/java/com/epam/training/artsiom_shylau"
                        + "/collections/optionaltask/testresources/empty.txt"));
    }

    @Test(expected = TextProcessorException.class)
    public void testGetSortedAlphabeticalLinesFromFileNullAsFilePath() throws TextProcessorException, IOException {
        textProcessor.getSortedAlphabeticalLinesFromFile(null);
    }

    @Test(expected = IOException.class)
    public void testGetSortedByLengthLinesFromFileFileDoesNotExist() throws TextProcessorException, IOException {
        textProcessor.getSortedByLengthLinesFromFile("test");
    }

    @Test
    public void testGetLinesFromFile() throws TextProcessorException, IOException {
        Assert.assertEquals(List.of("first", "second"), textProcessor.getLinesFromFile("src/test/java/com/epam"
                + "/training/artsiom_shylau/collections/optionaltask/testresources/for-get-lines.txt"));
    }

    @Test
    public void testRewriteLinesInFile() throws TextProcessorException, IOException {
        String filePathForThisTest = "src/test/java/com/epam/training/artsiom_shylau/collections"
                + "/optionaltask/testresources/for-get-lines.txt";
        textProcessor.rewriteLinesInFile(filePathForThisTest, List.of("new line", "new line"));
        Assert.assertEquals(List.of("new line", "new line"), textProcessor.getLinesFromFile(filePathForThisTest));
    }

    @Test
    public void testRewriteDigitsOfIntegerNumberFromFileInReverseOrder() throws TextProcessorException, IOException {
        String filePathForThisTest = "src/test/java/com/epam/training/artsiom_shylau/collections/optionaltask"
                                        + "/testresources/for-rewrite-digits-in-reverse-order.txt";
        textProcessor.rewriteDigitsOfIntegerNumberFromFileInReverseOrder(filePathForThisTest);
        Assert.assertEquals(List.of("54321"), textProcessor.getLinesFromFile(filePathForThisTest));
    }

    @Test(expected = TextProcessorException.class)
    public void testRewriteDigitsOfIntegerNumberFromFileInReverseOrderEmptyFile() throws TextProcessorException,
                                                                                            IOException {
        String filePathForThisTest = "src/test/java/com/epam/training/artsiom_shylau/collections/optionaltask"
                + "/testresources/empty.txt";
        textProcessor.rewriteDigitsOfIntegerNumberFromFileInReverseOrder(filePathForThisTest);
    }

    @Test
    public void testAppendLinesInFileInReverseOrder() throws TextProcessorException, IOException {
        String filePathForThisTest = "src/test/java/com/epam/training/artsiom_shylau"
                + "/collections/optionaltask/testresources/for-append-lines-in-reverse-order.txt";
        textProcessor.appendLinesInFileInReverseOrder(filePathForThisTest,
                                                        new ArrayList<>(List.of("first", "second", "third")));
        Assert.assertEquals(List.of("third", "second", "first"), textProcessor.getLinesFromFile(filePathForThisTest));
    }

    @Test
    public void testFindUniqueWordsInFile() throws TextProcessorException, IOException {
        Assert.assertEquals(new TreeSet<>(List.of("this", "is", "the", "house", "that", "jack", "built", "malt", "lay",
                "in", "rat", "ate")), new TreeSet<>(textProcessor.findUniqueWordsInFile("src/test/java/com/epam"
                + "/training/artsiom_shylau/collections/optionaltask/testresources/for-find-unique-words.txt")));
    }

    @Test
    public void testAppendStringInFile() throws TextProcessorException, IOException {
        String filePathForThisTest = "src/test/java/com/epam/training/artsiom_shylau"
                + "/collections/optionaltask/testresources/for-append-lines-in-reverse-order.txt";
        textProcessor.appendStringInFile(filePathForThisTest, "first\nsecond\nthird");
        Assert.assertEquals(List.of("first", "second", "third"), textProcessor.getLinesFromFile(filePathForThisTest));
    }

    @Test
    public void testGetTextFromFile() throws TextProcessorException, IOException {
        String filePathForThisTest = "src/test/java/com/epam/training/artsiom_shylau"
                + "/collections/optionaltask/testresources/for-append-lines-in-reverse-order.txt";
        textProcessor.appendStringInFile(filePathForThisTest, "test");
        Assert.assertEquals("test", textProcessor.getTextFromFile(filePathForThisTest));
    }

    @After
    public void resetChangesInFiles() throws TextProcessorException, IOException {
        textProcessor.rewriteLinesInFile("src/test/java/com/epam/training/artsiom_shylau/collections"
                + "/optionaltask/testresources/for-rewrite-digits-in-reverse-order.txt", List.of("12345"));
        textProcessor.rewriteLinesInFile("src/test/java/com/epam/training/artsiom_shylau/collections"
                + "/optionaltask/testresources/for-get-lines.txt", List.of("first", "second"));
        textProcessor.clearFile("src/test/java/com/epam/training/artsiom_shylau"
                + "/collections/optionaltask/testresources/for-append-lines-in-reverse-order.txt");
    }
}

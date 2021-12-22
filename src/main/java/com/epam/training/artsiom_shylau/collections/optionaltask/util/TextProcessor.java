package com.epam.training.artsiom_shylau.collections.optionaltask.util;

import com.epam.training.artsiom_shylau.collections.optionaltask.exceptions.TextProcessorException;
import com.epam.training.artsiom_shylau.collections.optionaltask.validation.TextProcessorValidator;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

public class TextProcessor {

    public void clearFile(String filePath) throws IOException {
        new FileOutputStream(filePath).close();
    }

    public void appendStringInFile(String filePath, String text) throws IOException, TextProcessorException {
        TextProcessorValidator.validateStringNull(filePath);
        TextProcessorValidator.validateStringNull(text);
        Files.write(Path.of(filePath), text.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
    }

    public String getTextFromFile(String filePath) throws IOException {
        return Files.readString(Path.of(filePath));
    }

    public List<String> getLinesFromFile(String filePath) throws IOException, TextProcessorException {
        TextProcessorValidator.validateStringNull(filePath);
        return Files.lines(Path.of(filePath)).collect(Collectors.toList());
    }

    public void appendLinesInFile(String filePath, List<String> lines) throws IOException, TextProcessorException {
        TextProcessorValidator.validateStringNull(filePath);
        TextProcessorValidator.validateListWithTextLines(lines);
        Files.write(Path.of(filePath), lines, StandardOpenOption.APPEND);
    }

    public void rewriteLinesInFile(String filePath, List<String> lines) throws IOException, TextProcessorException {
        TextProcessorValidator.validateStringNull(filePath);
        TextProcessorValidator.validateListWithTextLines(lines);
        Files.write(Path.of(filePath), lines);
    }

    public void appendLinesInFileInReverseOrder(String filePath, List<String> lines) throws IOException,
                                                                                    TextProcessorException {
        TextProcessorValidator.validateStringNull(filePath);
        TextProcessorValidator.validateListWithTextLines(lines);
        Collections.reverse(lines);
        Files.write(Path.of(filePath), lines, StandardOpenOption.APPEND);
    }

    public void rewriteLinesInFileInReverseOrder(String filePath, List<String> lines) throws IOException,
                                                                                        TextProcessorException {
        TextProcessorValidator.validateStringNull(filePath);
        TextProcessorValidator.validateListWithTextLines(lines);
        Collections.reverse(lines);
        Files.write(Path.of(filePath), lines);
    }

    public List<String> getSortedByLengthLinesFromFile(String filePath) throws IOException, TextProcessorException {
        List<String> linesFromFile = getLinesFromFile(filePath);
        linesFromFile.sort(Comparator.comparing(String::length));
        return linesFromFile;
    }

    public List<String> getSortedAlphabeticalLinesFromFile(String filePath) throws IOException, TextProcessorException {
        List<String> linesFromFile = getLinesFromFile(filePath);
        Collections.sort(linesFromFile);
        return linesFromFile;
    }

    public Set<String> findUniqueWordsInFile(String filePath) throws IOException, TextProcessorException {
        TextProcessorValidator.validateStringNull(filePath);
        String text =  Files.readString(Path.of(filePath));
        Scanner scanner = new Scanner(text.replaceAll("[.,();:-]+", ""));
        Set<String> words = new HashSet<>();
        while (scanner.hasNext()){
            words.add(scanner.next().toLowerCase());
        }
        scanner.close();
        return words;
    }


    public void rewriteDigitsOfIntegerNumberFromFileInReverseOrder(String filePath) throws IOException,
                                                                                    TextProcessorException {
        TextProcessorValidator.validateStringNull(filePath);
        Scanner scanner = new Scanner(Path.of(filePath));
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            Deque<Character> digitsOfNumber = new ArrayDeque<>();
            for (Character character : String.valueOf(number).toCharArray()) {
                digitsOfNumber.push(character);
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (Character character : digitsOfNumber) {
                stringBuilder.append(character);
            }
            Files.write(Path.of(filePath), stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
            scanner.close();
        } else {
            scanner.close();
            throw new TextProcessorException("must be integer number in file and only it");
        }
    }

}

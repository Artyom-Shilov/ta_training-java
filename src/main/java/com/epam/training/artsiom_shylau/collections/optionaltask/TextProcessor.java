package com.epam.training.artsiom_shylau.collections.optionaltask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class TextProcessor {

    public List<String> getLinesFromFile() throws IOException {
        return Files.lines(Path.of("")).collect(Collectors.toList());
    }

    public void writeLinesInFileInReverseOrder(String file, List<String> lines) throws IOException {
        Collections.reverse(lines);
        Files.write(Path.of(file), lines);
    }

    public void sortLinesByLength(List<String> lines) {
        lines.sort(Comparator.comparing(String::length));
    }

    public void sortLinesAlphabetical(List<String> lines) {
        Collections.sort(lines);
    }

    public Set<String> findDistinctWordsInFile(String path) throws IOException {
        Scanner scanner = new Scanner(Path.of(path));
        Set<String> words = new HashSet<>();
        while(scanner.hasNext()){
            words.add(scanner.next().toLowerCase());
        }
        return words;
    }

    public String getDigitsOfNumberFromFileInReverseOrder(int number) throws IOException {
        Deque<Character> digitsOfNumber = new ArrayDeque<>();
        for (Character character : String.valueOf(number).toCharArray()) {
            digitsOfNumber.push(character);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : digitsOfNumber) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }

}

package com.epam.training.artsiom_shylau.collections.optionaltask.validation;

import com.epam.training.artsiom_shylau.collections.optionaltask.exceptions.TextProcessorException;

import java.util.List;

public class TextProcessorValidator {
    public static void validateStringNull(String string) throws TextProcessorException {
        if (string == null) {
            throw new TextProcessorException("null as string");
        }
    }

    public static void validateListWithTextLines(List<String> lines) throws TextProcessorException {
        if (lines == null) {
            throw new TextProcessorException("null as text lines");
        }
    }
}

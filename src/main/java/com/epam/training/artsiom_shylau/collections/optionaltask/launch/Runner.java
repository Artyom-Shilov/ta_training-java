package com.epam.training.artsiom_shylau.collections.optionaltask.launch;

import com.epam.training.artsiom_shylau.collections.optionaltask.TextProcessor;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Runner {
    private final static Logger logger = Logger.getLogger(Runner.class);
    public static void main(String[] args) throws IOException {
        TextProcessor textProcessor = new TextProcessor();
        logger.log(Level.INFO, textProcessor.getDigitsOfNumberFromFileInReverseOrder(345));
    }
}

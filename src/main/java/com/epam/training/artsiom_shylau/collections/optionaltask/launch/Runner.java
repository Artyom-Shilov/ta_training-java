package com.epam.training.artsiom_shylau.collections.optionaltask.launch;

import com.epam.training.artsiom_shylau.collections.optionaltask.util.TextProcessor;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.io.PrintWriter;
import java.io.StringWriter;


public class Runner {

    private static final String FILE_PATH_FOR_POEM = "src/main/resources/textfiles/poem.txt";
    private static final String POEM = "Season of mists and mellow fruitfulness,\n" +
            "Close bosom - friend of the maturing sun;\n" +
            "Conspiring with him how to load and bless\n" +
            "With fruit the vines that round the thatch-eves run;\n" +
            "To bend with apples the moss'd cottage-trees,\n" +
            "And fill all fruit with ripeness to the core;\n" +
            "To swell the gourd, and plump the hazel shells\n" +
            "With a sweet kernel; to set budding more,\n" +
            "And still more, later flowers for the bees,\n" +
            "Until they think warm days will never cease,\n" +
            "For Summer has o'er - brimm'd their clammy cells.\n";
    private static final String FILE_PATH_FOR_NUMBER = "src/main/resources/textfiles/number.txt";
    private static final String NUMBER = "3459";


    private static Logger logger = Logger.getLogger(Runner.class);

    public static void main(String[] args) {
        try {
            logger.log(Level.INFO, "Start of program");
            TextProcessor textProcessor = new TextProcessor();
            textProcessor.clearFile(FILE_PATH_FOR_POEM);
            textProcessor.clearFile(FILE_PATH_FOR_NUMBER);
            textProcessor.appendStringInFile(FILE_PATH_FOR_POEM, POEM);
            logger.log(Level.INFO, "Poem is appended in file " + FILE_PATH_FOR_POEM + ":\n" + POEM);
            textProcessor.rewriteLinesInFileInReverseOrder(
                    FILE_PATH_FOR_POEM, textProcessor.getLinesFromFile(FILE_PATH_FOR_POEM));
            logger.log(Level.INFO, "Poem is rewritten with lines in reverse order:\n"
                    + textProcessor.getTextFromFile(FILE_PATH_FOR_POEM));
            logger.log(Level.INFO, "Lines of poem sorted by length: "
                    + textProcessor.getSortedByLengthLinesFromFile(FILE_PATH_FOR_POEM));
            logger.log(Level.INFO, "Lines of poem sorted alphabetical: "
                    + textProcessor.getSortedAlphabeticalLinesFromFile(FILE_PATH_FOR_POEM));
            logger.log(Level.INFO, "Unique words in poem: "
                    + textProcessor.findUniqueWordsInFile(FILE_PATH_FOR_POEM));
            textProcessor.appendStringInFile(FILE_PATH_FOR_NUMBER, NUMBER);
            logger.log(Level.INFO, "Number " + NUMBER + " is appended in file " + FILE_PATH_FOR_NUMBER);
            textProcessor.rewriteDigitsOfIntegerNumberFromFileInReverseOrder(FILE_PATH_FOR_NUMBER);
            logger.log(Level.INFO, "Number is rewritten with digits in reverse order: "
                    + textProcessor.getLinesFromFile(FILE_PATH_FOR_NUMBER));
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            logger.log(Level.ERROR, stringWriter.toString());
        }
    }
}

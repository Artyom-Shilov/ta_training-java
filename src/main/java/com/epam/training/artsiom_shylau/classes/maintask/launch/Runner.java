package com.epam.training.artsiom_shylau.classes.maintask.launch;

import com.epam.training.artsiom_shylau.classes.maintask.entity.Book;
import com.epam.training.artsiom_shylau.classes.maintask.storage.impl.ArrayBookStorage;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

public class Runner {

    private  static Logger logger = Logger.getLogger(Runner.class);
    private static final String AUTHOR_FOR_SEARCHING = "Robert Macfarlane";
    private static final String PUBLISHING_OFFICE_FOR_SEARCHING = "Graywolf Press";
    private static final int YEAR_FOR_SEARCHING = 2005;

    public static void main(String[] args) {
        try {
            logger.log(Level.INFO, "Start of program");
            ArrayBookStorage bookStorage = new ArrayBookStorage(
                    new Book.Builder().setTitle("Broken Glass").setAuthor("Alain Mabanckou")
                            .setPublishingOffice("Simon & Schuster").setPublicationYear(2005).build(),
                    new Book.Builder().setTitle("Underland").setAuthor("Robert Macfarlane")
                            .setPublishingOffice("penguin books UK").setPublicationYear(2019).build(),
                    new Book.Builder().setTitle("The Argonauts").setAuthor("Maggie Nelson")
                            .setPublishingOffice("Graywolf Press").setPublicationYear(2015).build()
            );
            logger.log(Level.INFO, "Current books in storage: \n" + Arrays.toString(bookStorage.getAllBooks()));
            logger.log(Level.INFO, "Books by " + AUTHOR_FOR_SEARCHING + ":\n"
                    +  Arrays.toString(bookStorage.findBooksByAuthor(AUTHOR_FOR_SEARCHING)));
            logger.log(Level.INFO, "Books by " + PUBLISHING_OFFICE_FOR_SEARCHING + " publishing office:\n"
                    +  Arrays.toString(bookStorage.findBooksByPublishingOffice(PUBLISHING_OFFICE_FOR_SEARCHING)));
            logger.log(Level.INFO, "Books published after " + YEAR_FOR_SEARCHING + ":\n"
                    +  Arrays.toString(bookStorage.findBooksPublishedAfterCertainYear(YEAR_FOR_SEARCHING)));
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            logger.log(Level.ERROR, stringWriter.toString());
        }
    }
}

package com.epam.training.artsiom_shylau.classes.main_task.launch;


import com.epam.training.artsiom_shylau.classes.main_task.entity.Book;
import com.epam.training.artsiom_shylau.classes.main_task.storage.impl.ArrayBookStorage;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        try {
            Book book1 = new Book("Broken Glass", "Alain Mabanckou", "Simon & Schuster",
                    2005);
            Book book2 = new Book("Underland", "Robert Macfarlane", "penguin books UK",
                    2019);
            Book book3 = new Book("The Argonauts", "Maggie Nelson", "Graywolf Press",
                    2015);
            ArrayBookStorage bookStorage = new ArrayBookStorage(book1, book2);
            bookStorage.addBook(book3);
            System.out.println("Books by Robert Macfarlane:");
            System.out.println(Arrays.toString(bookStorage.findBooksByAuthor("Robert Macfarlane")));
            System.out.println("Books by Graywolf Press publishing office:");
            System.out.println(Arrays.toString(bookStorage.findBooksByPublishingOffice("Graywolf Press")));
            System.out.println("Books are published after 2005:");
            System.out.println(Arrays.toString(bookStorage.findBooksPublishedAfterCertainYear(2005)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

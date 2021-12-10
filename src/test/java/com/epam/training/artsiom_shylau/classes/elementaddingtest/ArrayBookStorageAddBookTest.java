package com.epam.training.artsiom_shylau.classes.elementaddingtest;

import com.epam.training.artsiom_shylau.classes.maintask.entity.Book;
import com.epam.training.artsiom_shylau.classes.maintask.exceptions.BookException;
import com.epam.training.artsiom_shylau.classes.maintask.exceptions.BookStorageException;
import com.epam.training.artsiom_shylau.classes.maintask.storage.impl.ArrayBookStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayBookStorageAddBookTest {

    ArrayBookStorage bookStorage;

    @Before
    public void setUp() {
        bookStorage = new ArrayBookStorage();
    }

    @Test
    public void testAddBook() throws BookStorageException, BookException {
        bookStorage.addBook(new Book.Builder().build());
        bookStorage.addBook(new Book.Builder().build());
        bookStorage.addBook(new Book.Builder().build());
        bookStorage.addBook(new Book.Builder().build());
        Assert.assertEquals(4, bookStorage.getAmount());
    }

    @Test(expected = BookStorageException.class)
    public void testAddBookNullAsArgument() throws BookStorageException {
        bookStorage.addBook(null);
    }
}

package com.epam.training.artsiom_shylau.classes;

import com.epam.training.artsiom_shylau.classes.maintask.entity.Book;
import com.epam.training.artsiom_shylau.classes.maintask.exceptions.BookException;
import com.epam.training.artsiom_shylau.classes.maintask.exceptions.BookStorageException;
import com.epam.training.artsiom_shylau.classes.maintask.storage.impl.ArrayBookStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayBookStorageTest {

    ArrayBookStorage bookStorage;
    static Book firstTestBook;
    static Book secondTestBook;
    static Book thirdTestBook;
    static Book fourthTestBook;

    @BeforeClass
    public static void onceSetUp() throws BookException {
        firstTestBook = new Book.Builder().setAuthor("Agatha Christie").setPublishingOffice("Hachette Livre")
                .setPublicationYear(2001).build();
        secondTestBook = new Book.Builder().setAuthor("Danielle Steel").setPublishingOffice("Simon & Schuster")
                .setPublicationYear(1973).build();
        thirdTestBook = new Book.Builder().setAuthor("Danielle Steel").setPublishingOffice("Simon & Schuster")
                .setPublicationYear(1973).build();
        fourthTestBook = new Book.Builder().setAuthor("Danielle Steel, Barbara Cartland").setPublishingOffice("Simon")
                .setPublicationYear(34).build();
    }

    @Before
    public void setUp() throws BookStorageException {
        bookStorage = new ArrayBookStorage(firstTestBook, secondTestBook, thirdTestBook, fourthTestBook);
    }

    @Test
    public void testGetAllBooksNotEmptyStorage() {
        Assert.assertEquals(4, bookStorage.getAllBooks().length);
    }

    @Test
    public void testGetAllBooksEmptyStorage() {
        bookStorage = new ArrayBookStorage();
        Assert.assertEquals(0, bookStorage.getAllBooks().length);
    }

    @Test
    public void testFindBookByIdValidIdBookIsPresent() throws BookException {
        Assert.assertEquals(bookStorage.getAllBooks()[0],
                bookStorage.findBookById(1).orElse(new Book.Builder().build()));
    }

    @Test
    public void testFindBookByIdValidIdBookIsNotPresent() {
        Assert.assertFalse(bookStorage.findBookById(150).isPresent());
    }

    @Test
    public void testFindBookByIdInvalidId() {
        Assert.assertFalse(bookStorage.findBookById(-10).isPresent());
    }

    @Test
    public void testRemoveBookByIdValidIdBookIsPresent() {
        bookStorage.removeBookById(2);
        Assert.assertEquals(3, bookStorage.getAmount());
    }

    @Test
    public void testRemoveBookByIdValidIdElementIsNotPresent() {
        Assert.assertFalse(bookStorage.removeBookById(50));
    }

    @Test
    public void testRemoveBookByIdInvalidId() {
        Assert.assertFalse(bookStorage.removeBookById(-3));
    }

    @Test
    public void testFindBooksByPublishingOfficeBooksArePresent() {
        Assert.assertEquals(2, bookStorage.findBooksByPublishingOffice("Simon & Schuster").length);
    }

    @Test
    public void testFindBooksByPublishingOfficeBooksAreNotPresent() {
        Assert.assertEquals(0, bookStorage.findBooksByPublishingOffice("Farrar, Straus & Giroux").length);
    }

    @Test
    public void testFindBooksByPublishingOfficeBooksEmptyStorage() {
        Assert.assertEquals(0, bookStorage.findBooksByPublishingOffice("Farrar, Straus & Giroux").length);
    }

    @Test
    public void testFindBooksByPublishingOfficeBooksNullAsArgument() {
        Assert.assertEquals(0, bookStorage.findBooksByPublishingOffice(null).length);
    }

    @Test
    public void testFindBooksPublishedAfterCertainYearPositiveYearBookIsPresent() {
        Assert.assertEquals(1, bookStorage.findBooksPublishedAfterCertainYear(2000).length);
    }

    @Test
    public void testFindBooksPublishedAfterCertainYearPositiveYearBookIsNotPresent() {
        Assert.assertEquals(0, bookStorage.findBooksPublishedAfterCertainYear(2034).length);
    }

    @Test
    public void testFindBooksPublishedAfterCertainYearNegativeYear() {
        Assert.assertEquals(0, bookStorage.findBooksPublishedAfterCertainYear(-34).length);
    }

    @Test
    public void testFindBooksByAuthorBooksArePresent() throws BookStorageException {
        Assert.assertEquals(3, bookStorage.findBooksByAuthor("Danielle Steel").length);
    }

    @Test
    public void testFindBooksByAuthorBooksAreNotPresent() throws BookStorageException {
        Assert.assertEquals(0, bookStorage.findBooksByAuthor("Jeanine Cummins").length);
    }

    @Test(expected = BookStorageException.class)
    public void testFindBooksByAuthorNullAsArgument() throws BookStorageException {
        bookStorage.findBooksByAuthor(null);
    }

    @Test(expected = BookStorageException.class)
    public void testFindBooksByAuthorZeroLengthStringAsArgument() throws BookStorageException {
        bookStorage.findBooksByAuthor("");
    }
}

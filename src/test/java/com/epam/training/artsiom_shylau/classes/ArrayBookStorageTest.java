package com.epam.training.artsiom_shylau.classes;

import com.epam.training.artsiom_shylau.classes.main_task.entity.Book;
import com.epam.training.artsiom_shylau.classes.main_task.exceptions.BookStorageException;
import com.epam.training.artsiom_shylau.classes.main_task.storage.impl.ArrayBookStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayBookStorageTest {

    ArrayBookStorage bookStorage;
    Book firstTestBook;
    Book secondTestBook;
    Book thirdTestBook;
    Book fourthTestBook;

    @Before
    public void setUp() {
        bookStorage = new ArrayBookStorage();
        firstTestBook = new Book();
        secondTestBook = new Book();
        thirdTestBook = new Book();
        fourthTestBook = new Book();
    }

    @Test
    public void testAddBook() throws BookStorageException {
        bookStorage.addBook(firstTestBook);
        bookStorage.addBook(secondTestBook);
        bookStorage.addBook(thirdTestBook);
        Assert.assertEquals(3, bookStorage.getAmount());
    }

    @Test(expected = BookStorageException.class)
    public void testAddBookNullAsArgument() throws BookStorageException {
        bookStorage.addBook(null);
    }

    @Test
    public void testFindBookByIdValidIdBookIsPresent() throws BookStorageException {
        bookStorage.addBook(firstTestBook);
        bookStorage.addBook(secondTestBook);
        Book actual = bookStorage.findBookById(firstTestBook.getBookId()).orElse(new Book());
        Assert.assertEquals(firstTestBook, actual);
    }

    @Test
    public void testFindBookByIdValidIdBookIsNotPresent() throws BookStorageException {
        bookStorage.addBook(firstTestBook);
        bookStorage.addBook(secondTestBook);
        Assert.assertFalse(bookStorage.findBookById(150).isPresent());
    }

    @Test
    public void testFindBookByIdInvalidId() throws BookStorageException {
        bookStorage.addBook(firstTestBook);
        bookStorage.addBook(secondTestBook);
        Assert.assertFalse(bookStorage.findBookById(-10).isPresent());
    }

    @Test
    public void testGetAllBooksNotEmptyStorage() throws BookStorageException {
        bookStorage.addBook(firstTestBook);
        bookStorage.addBook(secondTestBook);
        Assert.assertEquals(2, bookStorage.getAllBooks().length);
    }

    @Test
    public void testGetAllBooksEmptyStorage() throws BookStorageException {
        Assert.assertEquals(0, bookStorage.getAllBooks().length);
    }


    @Test
    public void testRemoveBookByIdValidIdElementIsPresentAtTheEnd() throws BookStorageException {
        bookStorage.addBook(firstTestBook);
        bookStorage.addBook(secondTestBook);
        bookStorage.addBook(thirdTestBook);
        Book[] books = bookStorage.getAllBooks();
        Assert.assertTrue(bookStorage.removeBookById(thirdTestBook.getBookId())
                && bookStorage.getAmount() == 2 && books[0].equals(firstTestBook)
                && books[1].equals(secondTestBook));
    }

    @Test
    public void testRemoveBookByIdValidIdElementIsPresentNotAtTheEnd() throws BookStorageException {
        bookStorage.addBook(firstTestBook);
        bookStorage.addBook(secondTestBook);
        bookStorage.addBook(thirdTestBook);
        bookStorage.removeBookById(firstTestBook.getBookId());
        Book[] books = bookStorage.getAllBooks();
        Assert.assertTrue(bookStorage.getAmount() == 2 && books[0].equals(secondTestBook)
                && books[1].equals(thirdTestBook));
    }

    @Test
    public void testRemoveBookByIdValidIdElementIsNotPresent() throws BookStorageException {
        bookStorage.addBook(firstTestBook);
        Assert.assertFalse(bookStorage.removeBookById(50));
    }

    @Test
    public void testRemoveBookByIdInvalidId() throws BookStorageException {
        bookStorage.addBook(firstTestBook);
        Assert.assertFalse(bookStorage.removeBookById(-3));
    }

    @Test
    public void testFindBooksByPublishingOfficeBooksArePresent() throws BookStorageException {
        firstTestBook.setPublishingOffice("Hachette Livre");
        secondTestBook.setPublishingOffice("HarperCollins");
        thirdTestBook.setPublishingOffice("Simon & Schuster");
        fourthTestBook.setPublishingOffice("Simon & Schuster");
        bookStorage.addBook(firstTestBook);
        bookStorage.addBook(secondTestBook);
        bookStorage.addBook(thirdTestBook);
        bookStorage.addBook(fourthTestBook);
        Assert.assertEquals(2, bookStorage.findBooksByPublishingOffice("Simon & Schuster").length);
    }

    @Test
    public void testFindBooksByPublishingOfficeBooksAreNotPresent() throws BookStorageException {
        firstTestBook.setPublishingOffice("Hachette Livre");
        secondTestBook.setPublishingOffice("HarperCollins");
        thirdTestBook.setPublishingOffice("Simon & Schuster");
        fourthTestBook.setPublishingOffice("Simon & Schuster");
        bookStorage.addBook(firstTestBook);
        bookStorage.addBook(secondTestBook);
        bookStorage.addBook(thirdTestBook);
        bookStorage.addBook(fourthTestBook);
        Assert.assertEquals(0, bookStorage.findBooksByPublishingOffice("Farrar, Straus & Giroux").length);
    }

    @Test
    public void testFindBooksByPublishingOfficeBooksEmptyStorage() throws BookStorageException {
        Assert.assertEquals(0, bookStorage.findBooksByPublishingOffice("Farrar, Straus & Giroux").length);
    }

    @Test
    public void testFindBooksByPublishingOfficeBooksNullAsArgument() throws BookStorageException {
        Assert.assertEquals(0, bookStorage.findBooksByPublishingOffice(null).length);
    }

    @Test
    public void testFindBooksPublishedAfterCertainYearPositiveYearBookIsPresent() throws BookStorageException {
        firstTestBook.setPublicationYear(2000);
        secondTestBook.setPublicationYear(2001);
        thirdTestBook.setPublicationYear(1973);
        fourthTestBook.setPublicationYear(34);
        bookStorage.addBook(firstTestBook);
        bookStorage.addBook(secondTestBook);
        bookStorage.addBook(thirdTestBook);
        bookStorage.addBook(fourthTestBook);
        Assert.assertEquals(1, bookStorage.findBooksPublishedAfterCertainYear(2000).length);
    }

    @Test
    public void testFindBooksPublishedAfterCertainYearPositiveYearBookIsNotPresent() throws BookStorageException {
        firstTestBook.setPublicationYear(2000);
        secondTestBook.setPublicationYear(2001);
        thirdTestBook.setPublicationYear(1973);
        fourthTestBook.setPublicationYear(34);
        bookStorage.addBook(firstTestBook);
        bookStorage.addBook(secondTestBook);
        bookStorage.addBook(thirdTestBook);
        bookStorage.addBook(fourthTestBook);
        Assert.assertEquals(0, bookStorage.findBooksPublishedAfterCertainYear(2034).length);
    }

    @Test
    public void testFindBooksPublishedAfterCertainYearNegativeYear() throws BookStorageException {
        firstTestBook.setPublicationYear(2000);
        secondTestBook.setPublicationYear(2001);
        thirdTestBook.setPublicationYear(1973);
        fourthTestBook.setPublicationYear(34);
        bookStorage.addBook(firstTestBook);
        bookStorage.addBook(secondTestBook);
        bookStorage.addBook(thirdTestBook);
        bookStorage.addBook(fourthTestBook);
        Assert.assertEquals(0, bookStorage.findBooksPublishedAfterCertainYear(-34).length);
    }

    @Test
    public void testFindBooksByAuthorBooksArePresent() throws BookStorageException {
        firstTestBook.setAuthor("Agatha Christie");
        secondTestBook.setAuthor("Barbara Cartland");
        thirdTestBook.setAuthor("Danielle Steel");
        fourthTestBook.setAuthor("Danielle Steel, Barbara Cartland");
        bookStorage.addBook(firstTestBook);
        bookStorage.addBook(secondTestBook);
        bookStorage.addBook(thirdTestBook);
        bookStorage.addBook(fourthTestBook);
        Assert.assertEquals(2, bookStorage.findBooksByAuthor("Danielle Steel").length);
    }

    @Test
    public void testFindBooksByAuthorBooksAreNotPresent() throws BookStorageException {
        firstTestBook.setAuthor("Agatha Christie");
        secondTestBook.setAuthor("Barbara Cartland");
        thirdTestBook.setAuthor("Danielle Steel");
        fourthTestBook.setAuthor("Danielle Steel, Barbara Cartland");
        bookStorage.addBook(firstTestBook);
        bookStorage.addBook(secondTestBook);
        bookStorage.addBook(thirdTestBook);
        bookStorage.addBook(fourthTestBook);
        Assert.assertEquals(0, bookStorage.findBooksByAuthor("Jeanine Cummins").length);
    }

    @Test(expected = BookStorageException.class)
    public void testFindBooksByAuthorNullAsArgument() throws BookStorageException {
        bookStorage.findBooksByAuthor(null);
    }

    @Test(expected = BookStorageException.class)
    public void testFindBooksByAuthorZeroLengthStringAsArgument() throws BookStorageException {
        firstTestBook.setAuthor("Agatha Christie");
        secondTestBook.setAuthor("Barbara Cartland");
        bookStorage.addBook(firstTestBook);
        bookStorage.addBook(secondTestBook);
        bookStorage.findBooksByAuthor("");
    }






}

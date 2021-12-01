package com.epam.training.artsiom_shylau.classes.main_task.storage.impl;

import com.epam.training.artsiom_shylau.classes.main_task.entity.Book;
import com.epam.training.artsiom_shylau.classes.main_task.exceptions.BookStorageException;
import com.epam.training.artsiom_shylau.classes.main_task.storage.BookStorage;
import java.util.Arrays;
import java.util.Optional;

public class ArrayBookStorage implements BookStorage {

    private final int INITIAL_CAPACITY = 2;

    private Book[] books = new Book[INITIAL_CAPACITY];
    private int booksAmount;

    public ArrayBookStorage() {
    }

    public ArrayBookStorage(Book... b) throws BookStorageException {
        for (Book book : b){
            addBook(book);
        }
    }

    public void addBook(Book book) throws BookStorageException {
        if (book == null) {
            throw new BookStorageException("trying to add null as book");
        }
        if (booksAmount == books.length) {
            Book[] booksExtended = new Book[books.length * 2];
            System.arraycopy(books, 0, booksExtended, 0, books.length);
            books = booksExtended;
        }
        books[booksAmount++] = book;
    }

    public int getAmount() {
        return this.booksAmount;
    }

    public boolean removeBookById(int id) {
        if (id <= 0) {
            return false;
        }
        for (int i = 0; i < booksAmount; i++) {
            if (books[i].getBookId() == id) {
                if (i == books.length - 1) {
                    books[i] = null;
                } else {
                    System.arraycopy(books, i + 1, books, i, books.length - i - 1);
                }
                booksAmount--;
                return true;
            }
        }
        return false;
    }

    public Book[] getAllBooks() {
        return Arrays.stream(books).limit(booksAmount).toArray(Book[]::new);
    }

    public Optional<Book> findBookById(int id) {
        if (id <= 0) {
            return Optional.empty();
        }
        return Arrays.stream(books)
                .limit(booksAmount)
                .filter(b -> b.getBookId() == id)
                .findFirst();
    }

    public Book[] findBooksByAuthor(String authorName) throws BookStorageException {
        if (authorName == null || authorName.equals("") || authorName.equals(" ")) {
            throw new BookStorageException("wrong format for string argument");
        }
        return Arrays.stream(books)
                .limit(booksAmount)
                .filter(b -> b.getAuthor().contains(authorName))
                .toArray(Book[]::new);
    }

    public Book[] findBooksByPublishingOffice(String publishingOffice) {
        return Arrays.stream(books)
                .limit(booksAmount)
                .filter(b -> b.getPublishingOffice().equals(publishingOffice))
                .toArray(Book[]::new);
    }

    public Book[] findBooksPublishedAfterCertainYear(int year) {
        if (year <= 0) {
            return new Book[0];
        }
        return Arrays.stream(books)
                .limit(booksAmount)
                .filter(b -> b.getPublicationYear() > year)
                .toArray(Book[]::new);
    }

}

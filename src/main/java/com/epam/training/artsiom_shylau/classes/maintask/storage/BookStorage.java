package com.epam.training.artsiom_shylau.classes.maintask.storage;

import com.epam.training.artsiom_shylau.classes.maintask.entity.Book;
import com.epam.training.artsiom_shylau.classes.maintask.exceptions.BookStorageException;

import java.util.Optional;

public interface BookStorage {
    Object getAllBooks();
    int getAmount();
    void addBook(Book book) throws BookStorageException;
    boolean removeBookById(int id) throws BookStorageException;
    Optional<Book> findBookById(int id) throws BookStorageException;
    Object findBooksByAuthor(String authorName) throws BookStorageException;
    Object findBooksByPublishingOffice(String publishingOffice) throws BookStorageException;
    Object findBooksPublishedAfterCertainYear(int year) throws BookStorageException;
}

package com.epam.training.artsiom_shylau.classes.maintask.entity;

import com.epam.training.artsiom_shylau.classes.maintask.enums.BindingType;
import com.epam.training.artsiom_shylau.classes.maintask.exceptions.BookException;

import java.util.Objects;

public class Book {

    private static int globalIdValue;
    private int bookId;
    private String title;
    private String author;
    private String publishingOffice;
    private int numberOfPages;
    private int publicationYear;
    private double price;
    private BindingType binding;

    public Book(Builder builder) {
        globalIdValue++;
        this.bookId = globalIdValue;
        this.title = builder.title;
        this.author = builder.author;
        this.publishingOffice = builder.publishingOffice;
        this.numberOfPages = builder.numberOfPages;
        this.publicationYear = builder.publicationYear;
        this.price = builder.price;
        this.binding = builder.binding;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishingOffice() {
        return publishingOffice;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public double getPrice() {
        return price;
    }

    public BindingType getBinding() {
        return binding;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getBookId(){
        return this.bookId;
    }

    public static class Builder {
        private String title = "default";
        private String author = "default";
        private String publishingOffice = "default";
        private int numberOfPages;
        private int publicationYear;
        private double price;
        private BindingType binding = BindingType.HARDCOVER;

        public Builder setTitle(String title){
            this.title = title;
            return this;
        }

        public Builder setAuthor(String author){
            this.author = author;
            return this;
        }

        public Builder setPublishingOffice(String publishingOffice){
            this.publishingOffice = publishingOffice;
            return this;
        }

        public Builder setBinding(BindingType binding){
            this.binding = binding;
            return this;
        }

        public Builder setNumberOfPages(int numberOfPages){
            this.numberOfPages = numberOfPages;
            return this;
        }

        public Builder setPublicationYear(int publicationYear){
            this.publicationYear = publicationYear;
            return this;
        }

        public Builder setPrice(int price){
            this.price = price;
            return this;
        }

        private void validate() throws BookException {
            if (title == null || title.equals("") || title.equals(" ")){
                throw new BookException("wrong title format");
            }
            if (author == null || author.equals("") || author.equals(" ")){
                throw new BookException("wrong author's name format");
            }
            if (publishingOffice == null || publishingOffice.equals("") || publishingOffice.equals(" ")){
                throw new BookException("wrong publishing office format");
            }
            if (binding == null){
                throw new BookException("null as binding type");
            }
            if (numberOfPages < 0){
                throw new BookException("number of pages must be positive");
            }
            if (price < 0){
                throw new BookException("price must be positive");
            }
            if (publicationYear < 0){
                throw new BookException("year of publication must be positive");
            }
        }

        public Book build() throws BookException {
            validate();
            return new Book(this);
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishingOffice='" + publishingOffice + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", publicationYear=" + publicationYear +
                ", price=" + price +
                ", binding=" + binding +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if ((object == null) || (object.getClass() != this.getClass())){
            return false;
        }
        Book other = (Book) object;
        if ((this.bookId != other.bookId) || (this.price != other.price)
                || (this.numberOfPages != other.numberOfPages) || (this.binding != other.binding)
                || (this.publicationYear != other.publicationYear)) {
            return false;
        }
        return Objects.equals(this.title, other.title) && Objects.equals(this.author, other.author)
                && Objects.equals(this.publishingOffice, other.publishingOffice);
    }

    @Override
    public int hashCode() {
        return 31 + (int) (bookId + numberOfPages + publicationYear + price
                + ((title == null) ? 1 : title.hashCode())
                + ((author == null) ? 1 : numberOfPages)
                + ((publishingOffice == null) ? 1 : publishingOffice.hashCode())
                + ((binding == null) ? 1 : binding.hashCode()));
    }
}

package com.epam.training.artsiom_shylau.classes.main_task.entity;

import com.epam.training.artsiom_shylau.classes.main_task.enums.BindingType;

import java.util.Objects;

public class Book {

    private static int globalIdValue;
    private int bookId;
    private String name;
    private String author;
    private String publishingOffice;
    private int numberOfPages;
    private int publicationYear;
    private double cost;
    private BindingType binding;

    public Book() {
        globalIdValue++;
        this.bookId = globalIdValue;
        this.name = "default name";
        this.author = "default author";
        this.publishingOffice = "default publishing office";
        binding = BindingType.HARDCOVER;
    }

    public Book (String name, String author, String publishingOffice, int publicationYear){
        globalIdValue++;
        this.bookId = globalIdValue;
        this.name = name;
        this.author = author;
        this.publishingOffice = publishingOffice;
        this.publicationYear = publicationYear;
        binding = BindingType.HARDCOVER;
    }

    public Book (String name, String author, String publishingOffice, int numberOfPages,
                 int publicationYear, double cost, BindingType binding){
        globalIdValue++;
        this.bookId = globalIdValue;
        this.name = name;
        this.author = author;
        this.publishingOffice = publishingOffice;
        this.numberOfPages = numberOfPages;
        this.publicationYear = publicationYear;
        this.cost = cost;
        this.binding = binding;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingOffice() {
        return publishingOffice;
    }

    public void setPublishingOffice(String publishingOffice) {
        this.publishingOffice = publishingOffice;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public BindingType getBinding() {
        return binding;
    }

    public void setBinding(BindingType binding) {
        this.binding = binding;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getBookId(){
        return this.bookId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishingOffice='" + publishingOffice + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", publicationYear=" + publicationYear +
                ", cost=" + cost +
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
        if ((this.bookId != other.bookId) || (this.cost != other.cost)
                || (this.numberOfPages != other.numberOfPages) || (this.binding != other.binding)
                || (this.publicationYear != other.publicationYear)) {
            return false;
        }
        return Objects.equals(this.name, other.name) && Objects.equals(this.author, other.author)
                && Objects.equals(this.publishingOffice, other.publishingOffice);

    }


    @Override
    public int hashCode() {
        return 31 * (int) (bookId + numberOfPages + publicationYear + cost
                + ((name == null) ? 1 : name.hashCode())
                + ((author == null) ? 1 : numberOfPages)
                + ((publishingOffice == null) ? 1 : publishingOffice.hashCode())
                + ((binding == null) ? 1 : binding.hashCode()));
    }
}

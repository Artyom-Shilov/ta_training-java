package com.epam.training.artsiom_shylau.collections.main_task.entities.impl;

import com.epam.training.artsiom_shylau.collections.main_task.entities.BouquetComponent;
import com.epam.training.artsiom_shylau.collections.main_task.exceptions.ValidatorException;
import com.epam.training.artsiom_shylau.collections.main_task.validation.Validator;

import java.util.Objects;

public class Postcard implements BouquetComponent {

    private double height;
    private double length;
    private double price;
    private String text;

    public Postcard() {
        this.height = 6.0;
        this.length = 10.0;
        this.price = 1.0;
        this.text = "Happy Birthday!";
    }

    public Postcard(String text) throws ValidatorException {
        this.height = 6.0;
        this.length = 10.0;
        this.price = 1.0;
        setText(text);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws ValidatorException {
        Validator.validatePositive(height);
        this.height = height;
    }

    public void setLength(double length) throws ValidatorException {
        Validator.validatePositive(length);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws ValidatorException {
        Validator.validatePositive(price);
        this.price = price;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) throws ValidatorException {
        Validator.validateObjectNull(text);
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Postcard postcard = (Postcard) o;
        return Double.compare(postcard.height, height) == 0 && Double.compare(postcard.length, length) == 0
                && Double.compare(postcard.price, price) == 0 && Objects.equals(text, postcard.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, length, price, text);
    }

    @Override
    public String toString() {
        return "Postcard{" +
                "height=" + height +
                ", length=" + length +
                ", price=" + price +
                ", text='" + text + '\'' +
                '}';
    }
}

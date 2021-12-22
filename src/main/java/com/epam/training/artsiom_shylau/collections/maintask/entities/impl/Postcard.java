package com.epam.training.artsiom_shylau.collections.maintask.entities.impl;

import com.epam.training.artsiom_shylau.collections.maintask.entities.BouquetComponent;
import com.epam.training.artsiom_shylau.collections.maintask.exceptions.PostcardException;
import java.util.Objects;

public class Postcard implements BouquetComponent {

    private double height;
    private double length;
    private double price;
    private String text;

    public Postcard(Builder builder) {
        this.height = builder.height;
        this.length = builder.length;
        this.price = builder.price;
        this.text = builder.text;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getPrice() {
        return price;
    }

    public String getText() {
        return text;
    }

    public static class Builder {
        private double height = 6.0;
        private double length = 10.0;
        private double price = 1.0;
        private String text = "Happy Birthday!";

        public Builder setHeight(double height) {
            this.height = height;
            return this;
        }

        public Builder setLength(double length) {
            this.length = length;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        private void validate() throws PostcardException {
            if (height <= 0) {
                throw new PostcardException("postcard height must be positive");
            }
            if (length <= 0) {
                throw new PostcardException("postcard length must be positive");
            }
            if (price <= 0) {
                throw new PostcardException("postcard length must be positive");
            }
            if (text == null) {
                throw new PostcardException("null as text");
            }
        }

        public Postcard build() throws PostcardException {
            validate();
            return new Postcard(this);
        }
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

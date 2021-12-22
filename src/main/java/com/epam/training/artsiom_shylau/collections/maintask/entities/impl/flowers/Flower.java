package com.epam.training.artsiom_shylau.collections.maintask.entities.impl.flowers;

import com.epam.training.artsiom_shylau.collections.maintask.entities.BouquetComponent;
import com.epam.training.artsiom_shylau.collections.maintask.enums.Color;
import com.epam.training.artsiom_shylau.collections.maintask.exceptions.FlowerException;
import java.util.Objects;

public abstract class Flower implements BouquetComponent {

    String kind;
    double price;
    double stemLength;
    int daysAfterSlice;
    Color color;

    public Flower(Builder<?> builder) {
        this.kind = builder.kind;
        this.color = builder.color;
        this.price = builder.price;
        this.stemLength = builder.stemLength;
        this.daysAfterSlice = builder.daysAfterSlice;
    }

    public String getKind() {
        return kind;
    }

    public double getPrice() {
        return price;
    }

    public double getStemLength() {
        return stemLength;
    }

    public int getDaysAfterSlice() {
        return daysAfterSlice;
    }

    public Color getColor() {
        return color;
    }

    public static abstract class Builder<T extends Builder> {

        private String kind = "default kind";
        private double price = 3;
        private double stemLength = 35.0;
        private int daysAfterSlice = 0;
        private Color color = Color.WHITE;

        abstract T getSelf();

        public T setKind(String kind) {
            this.kind = kind;
            return getSelf();
        }

        public T setColor(Color color) {
            this.color = color;
            return getSelf();
        }

        public T setPrice(double price) {
            this.price = price;
            return getSelf();
        }

        public T setStemLength(double stemLength) {
            this.stemLength = stemLength;
            return getSelf();
        }

        public T setDaysAfterSlice(int daysAfterSlice) {
            this.daysAfterSlice = daysAfterSlice;
            return getSelf();
        }

        void validate() throws FlowerException {
            if (kind == null) {
                throw new FlowerException("null as kind");
            }
            if (color == null) {
                throw new FlowerException("null as color");
            }
            if (price <= 0) {
                throw new FlowerException("price must be positive");
            }
            if (stemLength <= 0) {
                throw new FlowerException("length of flower's stem must be positive");
            }
            if (daysAfterSlice < 0) {
                throw new FlowerException("number of days after slice can't be negative");
            }
        }

        public abstract Flower build() throws FlowerException;
    }


    public abstract String spreadSmell();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return Double.compare(flower.price, price) == 0 && Double.compare(flower.stemLength, stemLength) == 0
                && daysAfterSlice == flower.daysAfterSlice && Objects.equals(kind, flower.kind)
                && color == flower.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kind, price, stemLength, daysAfterSlice, color);
    }

    @Override
    public String toString() {
        return "Flower{" +
                "kind='" + kind + '\'' +
                ", price=" + price +
                ", stemLength=" + stemLength +
                ", daysAfterSlice=" + daysAfterSlice +
                ", color=" + color +
                '}';
    }
}

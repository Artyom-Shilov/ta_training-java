package com.epam.training.artsiom_shylau.collections.main_task.entities.impl.flowers;

import com.epam.training.artsiom_shylau.collections.main_task.entities.BouquetComponent;
import com.epam.training.artsiom_shylau.collections.main_task.enums.Color;
import com.epam.training.artsiom_shylau.collections.main_task.exceptions.ValidatorException;
import com.epam.training.artsiom_shylau.collections.main_task.validation.Validator;

import java.util.Objects;

public abstract class Flower implements BouquetComponent {

    String kind;
    double price;
    double stemLength;
    int daysAfterSlice;
    Color color;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) throws ValidatorException {
        Validator.validateObjectNull(kind);
        this.kind = kind;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws ValidatorException {
        Validator.validatePositive(price);
        this.price = price;
    }

    public double getStemLength() {
        return stemLength;
    }

    public void setStemLength(double stemLength) throws ValidatorException {
        Validator.validatePositive(stemLength);
        this.stemLength = stemLength;
    }

    public int getDaysAfterSlice() {
        return daysAfterSlice;
    }

    public void setDaysAfterSlice(int daysAfterSlice) throws ValidatorException {
        Validator.validatePositive(daysAfterSlice);
        this.daysAfterSlice = daysAfterSlice;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) throws ValidatorException {
        Validator.validateObjectNull(color);
        this.color = color;
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

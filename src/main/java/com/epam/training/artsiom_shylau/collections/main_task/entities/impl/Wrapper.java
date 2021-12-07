package com.epam.training.artsiom_shylau.collections.main_task.entities.impl;

import com.epam.training.artsiom_shylau.collections.main_task.entities.BouquetComponent;
import com.epam.training.artsiom_shylau.collections.main_task.enums.Color;
import com.epam.training.artsiom_shylau.collections.main_task.enums.Material;
import com.epam.training.artsiom_shylau.collections.main_task.exceptions.ValidatorException;
import com.epam.training.artsiom_shylau.collections.main_task.validation.Validator;

import java.util.Objects;

public class Wrapper implements BouquetComponent {

    private Material material;
    private Color color;
    private double length;
    private double height;
    private double price;

    public Wrapper(){
        this.material = Material.PAPER;
        this.color = Color.WHITE;
        this.height = 25.0;
        this.length = 50.0;
        this.price = 2;
    }

    public Wrapper(Material material, Color color, double length, double height, double price) throws ValidatorException {
       setMaterial(material);
       setColor(color);;
       setHeight(height);
       setLength(length);
       setPrice(price);
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) throws ValidatorException {
        Validator.validateObjectNull(material);
        this.material = material;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) throws ValidatorException {
        Validator.validateObjectNull(color);
        this.color = color;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) throws ValidatorException {
        Validator.validatePositive(length);
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws ValidatorException {
        Validator.validatePositive(height);
        this.height = height;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws ValidatorException {
        Validator.validatePositive(price);
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wrapper wrapper = (Wrapper) o;
        return Double.compare(wrapper.length, length) == 0 && Double.compare(wrapper.height, height) == 0
                && Double.compare(wrapper.price, price) == 0 && material == wrapper.material && color == wrapper.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, color, length, height, price);
    }

    @Override
    public String toString() {
        return "Wrapper{" +
                "material=" + material +
                ", color=" + color +
                ", length=" + length +
                ", height=" + height +
                ", price=" + price +
                '}';
    }
}

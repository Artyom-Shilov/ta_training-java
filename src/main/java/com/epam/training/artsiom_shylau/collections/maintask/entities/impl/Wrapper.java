package com.epam.training.artsiom_shylau.collections.maintask.entities.impl;

import com.epam.training.artsiom_shylau.collections.maintask.entities.BouquetComponent;
import com.epam.training.artsiom_shylau.collections.maintask.enums.Color;
import com.epam.training.artsiom_shylau.collections.maintask.enums.Material;
import com.epam.training.artsiom_shylau.collections.maintask.exceptions.WrapperException;

import java.util.Objects;

public class Wrapper implements BouquetComponent {

    private Material material;
    private Color color;
    private double length;
    private double height;
    private double price;

    public Wrapper(Builder builder) throws WrapperException {
        this.material = builder.material;
        this.color = builder.color;
        this.height = builder.height;
        this.length = builder.length;
        this.price = builder.price;
    }

    public Material getMaterial() {
        return material;
    }

    public Color getColor() {
        return color;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public double getPrice() {
        return price;
    }

    public static class Builder {
        private Material material = Material.PAPER;
        private Color color = Color.WHITE;
        private double length = 25.0;
        private double height = 60.0;
        private double price = 2.0;

        public Builder setMaterial(Material material) {
            this.material = material;
            return this;
        }

        public Builder setColor(Color color) {
            this.color = color;
            return this;
        }

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

        private void validate() throws WrapperException {
            if (material == null) {
                throw new WrapperException("null as wrapper material");
            }
            if (color == null) {
                throw new WrapperException("null as wrapper color");
            }
            if (height <= 0) {
                throw new WrapperException("wrapper height must be positive");
            }
            if (length <= 0) {
                throw new WrapperException("wrapper length must be positive");
            }
            if (price <= 0) {
                throw new WrapperException("wrapper length must be positive");
            }
        }

        public Wrapper build() throws WrapperException {
            validate();
            return new Wrapper(this);
        }
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

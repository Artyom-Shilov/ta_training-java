package com.epam.training.artsiom_shylau.collections.maintask.entities.impl.flowers;

import com.epam.training.artsiom_shylau.collections.maintask.exceptions.FlowerException;

public class RoseFlower extends Flower {

    public RoseFlower(Builder builder) throws FlowerException {
        super(builder);
    }

    public static class Builder extends Flower.Builder<Builder> {

        @Override
        public Builder getSelf() {
            return this;
        }

        @Override
        public RoseFlower build() throws FlowerException {
            validate();
            return new RoseFlower(getSelf());
        }
    }

    @Override
    public String spreadSmell() {
        return "smells like rose";
    }

    @Override
    public String toString() {
        return "RoseFlower{" +
                "kind='" + kind + '\'' +
                ", price=" + price +
                ", stemLength=" + stemLength +
                ", daysAfterSlice=" + daysAfterSlice +
                ", color=" + color +
                '}';
    }
}

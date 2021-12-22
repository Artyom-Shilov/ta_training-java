package com.epam.training.artsiom_shylau.collections.maintask.entities.impl.flowers;

import com.epam.training.artsiom_shylau.collections.maintask.exceptions.FlowerException;

public class LilyFlower extends Flower {

    public LilyFlower(Builder builder) {
       super(builder);
    }

    public static class Builder extends Flower.Builder<Builder> {

        @Override
        public Builder getSelf() {
            return this;
        }

        @Override
        public LilyFlower build() throws FlowerException {
            validate();
            return new LilyFlower(getSelf());
        }
    }

    @Override
    public String spreadSmell() {
        return "smells like lily";
    }

    @Override
    public String toString() {
        return "LilyFlower{" +
                "kind='" + kind + '\'' +
                ", price=" + price +
                ", stemLength=" + stemLength +
                ", daysAfterSlice=" + daysAfterSlice +
                ", color=" + color +
                '}';
    }
}

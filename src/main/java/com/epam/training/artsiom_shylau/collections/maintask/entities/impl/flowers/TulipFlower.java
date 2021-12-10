package com.epam.training.artsiom_shylau.collections.maintask.entities.impl.flowers;

import com.epam.training.artsiom_shylau.collections.maintask.exceptions.FlowerException;

public class TulipFlower extends Flower {

    public TulipFlower (Builder builder) throws FlowerException {
        super(builder);
    }

    public static class Builder extends Flower.Builder<Builder> {

        @Override
        public Builder getSelf() {
            return this;
        }

        @Override
        public TulipFlower build() throws FlowerException {
            validate();
            return new TulipFlower(getSelf());
        }
    }

    @Override
    public String spreadSmell() {
        return "smells like tulip";
    }

    @Override
    public String toString() {
        return "TulipFlower{" +
                "kind='" + kind + '\'' +
                ", price=" + price +
                ", stemLength=" + stemLength +
                ", daysAfterSlice=" + daysAfterSlice +
                ", color=" + color +
                '}';
    }
}

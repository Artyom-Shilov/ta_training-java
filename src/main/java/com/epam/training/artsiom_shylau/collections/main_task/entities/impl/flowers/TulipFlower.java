package com.epam.training.artsiom_shylau.collections.main_task.entities.impl.flowers;

import com.epam.training.artsiom_shylau.collections.main_task.enums.Color;
import com.epam.training.artsiom_shylau.collections.main_task.exceptions.ValidatorException;

public class TulipFlower extends Flower {

    public TulipFlower(){
        this.daysAfterSlice = 0;
        this.color = Color.WHITE;
        this.price = 3.0;
        this.stemLength = 30.0;
        this.kind = "Fosteriana";
    }

    public TulipFlower(String kind, Color color, double price, double stemLength, int daysAfterSlice) throws ValidatorException {
        setKind(kind);
        setColor(color);
        setPrice(price);
        setStemLength(stemLength);
        setDaysAfterSlice(daysAfterSlice);
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

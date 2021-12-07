package com.epam.training.artsiom_shylau.collections.main_task.entities.impl.flowers;

import com.epam.training.artsiom_shylau.collections.main_task.enums.Color;
import com.epam.training.artsiom_shylau.collections.main_task.exceptions.ValidatorException;

public class LilyFlower extends Flower {

    public LilyFlower(){
        this.daysAfterSlice = 0;
        this.color = Color.YELLOW;
        this.price = 2.5;
        this.stemLength = 30.0;
        this.kind = "Asiatic";
    }

    public LilyFlower(String kind, Color color, double price, double stemLength, int daysAfterSlice) throws ValidatorException {
        setKind(kind);
        setColor(color);
        setPrice(price);
        setStemLength(stemLength);
        setDaysAfterSlice(daysAfterSlice);
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

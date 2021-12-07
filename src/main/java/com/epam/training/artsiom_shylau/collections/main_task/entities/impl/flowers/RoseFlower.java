package com.epam.training.artsiom_shylau.collections.main_task.entities.impl.flowers;


import com.epam.training.artsiom_shylau.collections.main_task.enums.Color;
import com.epam.training.artsiom_shylau.collections.main_task.exceptions.ValidatorException;

public class RoseFlower extends Flower {

    public RoseFlower(){
        this.daysAfterSlice = 0;
        this.color = Color.RED;
        this.price = 3.0;
        this.stemLength = 30.0;
        this.kind = "Modern Garden";
    }

    public RoseFlower(String kind, Color color, double price, double stemLength, int daysAfterSlice) throws ValidatorException {
        setKind(kind);
        setColor(color);
        setPrice(price);
        setStemLength(stemLength);
        setDaysAfterSlice(daysAfterSlice);
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
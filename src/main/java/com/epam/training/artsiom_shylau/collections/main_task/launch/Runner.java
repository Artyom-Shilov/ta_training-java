package com.epam.training.artsiom_shylau.collections.main_task.launch;

import com.epam.training.artsiom_shylau.collections.main_task.entities.impl.Postcard;
import com.epam.training.artsiom_shylau.collections.main_task.entities.impl.Wrapper;
import com.epam.training.artsiom_shylau.collections.main_task.entities.impl.flowers.LilyFlower;
import com.epam.training.artsiom_shylau.collections.main_task.entities.impl.flowers.RoseFlower;
import com.epam.training.artsiom_shylau.collections.main_task.entities.impl.flowers.TulipFlower;
import com.epam.training.artsiom_shylau.collections.main_task.operator.Florist;

public class Runner {
    public static void main(String[] args) {
        try {
            Florist florist = new Florist();
            Wrapper wrapper = new Wrapper();
            Postcard postcard = new Postcard();
            RoseFlower rose = new RoseFlower();
            LilyFlower lily = new LilyFlower();
            TulipFlower tulip = new TulipFlower();
            rose.setDaysAfterSlice(10);
            lily.setDaysAfterSlice(5);
            tulip.setDaysAfterSlice(7);
            tulip.setStemLength(45);
            Florist.Bouquet bouquet = florist.collectBouquet(wrapper, postcard, rose, lily, tulip);
            System.out.println(bouquet);
            florist.sortFlowersByFreshness(bouquet);
            System.out.println("Bouquet after freshness sort: " + bouquet);
            System.out.println("price of bouquet: "  + florist.countBouquetPrice(bouquet));
            System.out.println("flowers in bouquet with stem length between 20 and 35: "
                    + florist.findFlowersByStemLength(bouquet, 20, 35));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
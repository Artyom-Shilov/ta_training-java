package com.epam.training.artsiom_shylau.collections.maintask.launch;

import com.epam.training.artsiom_shylau.collections.maintask.entities.impl.Postcard;
import com.epam.training.artsiom_shylau.collections.maintask.entities.impl.Wrapper;
import com.epam.training.artsiom_shylau.collections.maintask.entities.impl.flowers.LilyFlower;
import com.epam.training.artsiom_shylau.collections.maintask.entities.impl.flowers.RoseFlower;
import com.epam.training.artsiom_shylau.collections.maintask.entities.impl.flowers.TulipFlower;
import com.epam.training.artsiom_shylau.collections.maintask.util.Florist;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Runner {

    private static Logger logger = Logger.getLogger(Runner.class);
    private final static int START_VALUE_FOR_SEARCHING_BY_STEM_LENGTH = 20;
    private final static int END_VALUE_FOR_SEARCHING_BY_STEM_LENGTH = 40;

    public static void main(String[] args) {
        try {
            logger.log(Level.INFO, "Start program");
            Florist florist = new Florist();
            Wrapper wrapper = new Wrapper.Builder().build();
            Postcard postcard = new Postcard.Builder().build();
            RoseFlower rose = new RoseFlower.Builder().setDaysAfterSlice(10).build();
            LilyFlower lily = new LilyFlower.Builder().setDaysAfterSlice(5).setPrice(12.5).build();
            TulipFlower tulip = new TulipFlower.Builder().setDaysAfterSlice(7).setStemLength(45).build();
            Florist.Bouquet bouquet = florist.collectBouquet(wrapper, postcard, rose, lily, tulip);
            logger.log(Level.INFO, "Initial bouquet: " + bouquet);
            florist.sortFlowersByDaysAfterSlice(bouquet);
            logger.log(Level.INFO, "Bouquet sorted by number of days after slice: " + bouquet);
            logger.log(Level.INFO, "Price of bouquet: " + florist.countBouquetPrice(bouquet));
            logger.log(Level.INFO, "Flowers in bouquet with stem length between "
                    + START_VALUE_FOR_SEARCHING_BY_STEM_LENGTH + " and " + END_VALUE_FOR_SEARCHING_BY_STEM_LENGTH
                    + ": " + florist.findFlowersByStemLength(bouquet, START_VALUE_FOR_SEARCHING_BY_STEM_LENGTH
                    , END_VALUE_FOR_SEARCHING_BY_STEM_LENGTH));
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            logger.log(Level.ERROR, stringWriter.toString());
        }
    }
}
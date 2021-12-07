package com.epam.training.artsiom_shylau.collections.main_task;

import com.epam.training.artsiom_shylau.collections.main_task.entities.impl.Postcard;
import com.epam.training.artsiom_shylau.collections.main_task.entities.impl.Wrapper;
import com.epam.training.artsiom_shylau.collections.main_task.entities.impl.flowers.LilyFlower;
import com.epam.training.artsiom_shylau.collections.main_task.entities.impl.flowers.RoseFlower;
import com.epam.training.artsiom_shylau.collections.main_task.entities.impl.flowers.TulipFlower;
import com.epam.training.artsiom_shylau.collections.main_task.exceptions.FloristException;
import com.epam.training.artsiom_shylau.collections.main_task.exceptions.ValidatorException;
import com.epam.training.artsiom_shylau.collections.main_task.operator.Florist;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FloristTest {

    Wrapper wrapper;
    Postcard postcard;
    RoseFlower rose;
    LilyFlower lily;
    TulipFlower tulip;
    Florist florist;

    @Before
    public void setUp(){
        wrapper = new Wrapper();
        postcard = new Postcard();
        rose = new RoseFlower();
        lily = new LilyFlower();
        tulip = new TulipFlower();
        florist = new Florist();
    }

    @Test
    public void testCollectBouquetValidData() throws FloristException {
        Assert.assertEquals(4, florist.collectBouquet(wrapper, postcard, rose, lily).getNumberOfComponents());
    }

    @Test
    public void testCollectBouquetOnlyFlowersValidData() throws FloristException {
        Assert.assertEquals(4, florist.collectBouquet(rose, tulip, rose, lily).getNumberOfComponents());
    }

    @Test(expected = FloristException.class)
    public void testCollectBouquetNullAsArgument() throws FloristException {
        florist.collectBouquet(wrapper, null, rose, lily);
    }

    @Test(expected = FloristException.class)
    public void testCollectBouquetOnlyFlowersNullArrayAsArgument() throws FloristException {
        florist.collectBouquet(null);
    }

    @Test(expected = FloristException.class)
    public void testCollectBouquetOnlyFlowersNullAsFlower() throws FloristException {
        florist.collectBouquet(rose, null, lily);
    }

    @Test
    public void testCountBouquetPriceValidData() throws FloristException {
       Florist.Bouquet bouquet = florist.collectBouquet(wrapper, postcard, rose, lily);
        double actual = wrapper.getPrice() + postcard.getPrice() + rose.getPrice() + lily.getPrice();
        Assert.assertEquals(actual, florist.countBouquetPrice(bouquet), 0.001);
    }

    @Test(expected = FloristException.class)
    public void testCountBouquetPriceNullAsList() throws FloristException {
        florist.countBouquetPrice(null);
    }

    @Test
    public void testFindFlowersByStemLengthValidData() throws ValidatorException, FloristException {
        rose.setStemLength(23);
        tulip.setStemLength(3);
        lily.setStemLength(15);
        Florist.Bouquet bouquet = florist.collectBouquet(wrapper, postcard, rose, lily, tulip);
        Assert.assertEquals(lily, florist.findFlowersByStemLength(bouquet, 4, 22).get(0));
    }

    @Test(expected = FloristException.class)
    public void testFindFlowersByStemLengthNullAsArgument() throws FloristException {
        florist.findFlowersByStemLength(null, 4, 22);
    }

    @Test
    public void testFindFlowersByStemLengthFromMoreThanTo() throws FloristException {
        Assert.assertEquals(0, florist.findFlowersByStemLength(florist.collectBouquet(rose), 100, 0).size());
    }

    @Test
    public void testSortFlowersByFreshnessOnlyFlowersValidData() throws ValidatorException, FloristException {
        rose.setDaysAfterSlice(3);
        tulip.setDaysAfterSlice(0);
        lily.setDaysAfterSlice(21);
        Florist.Bouquet bouquetActual = florist.collectBouquet(rose, tulip, lily);
        florist.sortFlowersByFreshness(bouquetActual);
        Florist.Bouquet bouquetExpected = florist.collectBouquet(tulip, rose, lily);
        Assert.assertEquals(bouquetExpected.toString(), bouquetActual.toString());
    }

    @Test
    public void testSortFlowersByFreshnessAllComponentsValidData() throws ValidatorException, FloristException {
        rose.setDaysAfterSlice(34);
        tulip.setDaysAfterSlice(17);
        lily.setDaysAfterSlice(9);
        Florist.Bouquet bouquetActual = florist.collectBouquet(wrapper, postcard, rose, tulip, lily);
        florist.sortFlowersByFreshness(bouquetActual);
        Florist.Bouquet bouquetExpected = florist.collectBouquet(wrapper, postcard, lily, tulip, rose);
        Assert.assertEquals(bouquetExpected.toString(), bouquetActual.toString());
    }

    @Test(expected = FloristException.class)
    public void testSortFlowersByFreshnessNullAsArgument() throws FloristException{
        florist.sortFlowersByFreshness(null);
    }



}

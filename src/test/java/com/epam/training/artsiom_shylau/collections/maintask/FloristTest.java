package com.epam.training.artsiom_shylau.collections.maintask;

import com.epam.training.artsiom_shylau.collections.maintask.entities.impl.Postcard;
import com.epam.training.artsiom_shylau.collections.maintask.entities.impl.Wrapper;
import com.epam.training.artsiom_shylau.collections.maintask.entities.impl.flowers.LilyFlower;
import com.epam.training.artsiom_shylau.collections.maintask.entities.impl.flowers.RoseFlower;
import com.epam.training.artsiom_shylau.collections.maintask.entities.impl.flowers.TulipFlower;
import com.epam.training.artsiom_shylau.collections.maintask.exceptions.FloristException;
import com.epam.training.artsiom_shylau.collections.maintask.exceptions.FlowerException;
import com.epam.training.artsiom_shylau.collections.maintask.exceptions.PostcardException;
import com.epam.training.artsiom_shylau.collections.maintask.exceptions.WrapperException;
import com.epam.training.artsiom_shylau.collections.maintask.util.Florist;
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
    public void setUp() throws PostcardException, WrapperException, FlowerException {
        wrapper = new Wrapper.Builder().build();
        postcard = new Postcard.Builder().build();
        rose = new RoseFlower.Builder().build();
        lily = new LilyFlower.Builder().build();
        tulip = new TulipFlower.Builder().build();
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
    public void testFindFlowersByStemLengthValidData() throws FloristException, FlowerException {
        rose = new RoseFlower.Builder().setStemLength(23).build();
        tulip = new TulipFlower.Builder().setStemLength(3).build();
        lily = new LilyFlower.Builder().setStemLength(15).build();
        Florist.Bouquet bouquet = florist.collectBouquet(wrapper, postcard, rose, lily, tulip);
        Assert.assertEquals(lily, florist.findFlowersByStemLength(bouquet, 4, 22).get(0));
    }

    @Test(expected = FloristException.class)
    public void testFindFlowersByStemLengthNullAsArgument() throws FloristException {
        florist.findFlowersByStemLength(null, 4, 22);
    }

    @Test
    public void testFindFlowersByStemLengthFromMoreThanTo() throws FloristException {
        Assert.assertEquals(0, florist.findFlowersByStemLength(
                florist.collectBouquet(rose), 100, 0).size());
    }

    @Test
    public void testSortFlowersByFreshnessOnlyFlowersValidData() throws FloristException, FlowerException {
        rose = new RoseFlower.Builder().setDaysAfterSlice(3).build();
        tulip = new TulipFlower.Builder().setDaysAfterSlice(0).build();
        lily = new LilyFlower.Builder().setDaysAfterSlice(21).build();
        Florist.Bouquet bouquetActual = florist.collectBouquet(rose, tulip, lily);
        florist.sortFlowersByDaysAfterSlice(bouquetActual);
        Florist.Bouquet bouquetExpected = florist.collectBouquet(tulip, rose, lily);
        Assert.assertEquals(bouquetExpected.toString(), bouquetActual.toString());
    }

    @Test
    public void testSortFlowersByFreshnessAllComponentsValidData() throws FloristException, FlowerException {
        rose = new RoseFlower.Builder().setDaysAfterSlice(34).build();
        tulip = new TulipFlower.Builder().setDaysAfterSlice(17).build();
        lily = new LilyFlower.Builder().setDaysAfterSlice(9).build();
        Florist.Bouquet bouquetActual = florist.collectBouquet(wrapper, postcard, rose, tulip, lily);
        florist.sortFlowersByDaysAfterSlice(bouquetActual);
        Florist.Bouquet bouquetExpected = florist.collectBouquet(wrapper, postcard, lily, tulip, rose);
        Assert.assertEquals(bouquetExpected.toString(), bouquetActual.toString());
    }

    @Test(expected = FloristException.class)
    public void testSortFlowersByFreshnessNullAsArgument() throws FloristException{
        florist.sortFlowersByDaysAfterSlice(null);
    }
}

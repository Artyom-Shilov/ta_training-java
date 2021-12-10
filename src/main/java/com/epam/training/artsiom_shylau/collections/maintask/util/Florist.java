package com.epam.training.artsiom_shylau.collections.maintask.util;

import com.epam.training.artsiom_shylau.collections.maintask.entities.*;
import com.epam.training.artsiom_shylau.collections.maintask.entities.impl.flowers.Flower;
import com.epam.training.artsiom_shylau.collections.maintask.entities.impl.Postcard;
import com.epam.training.artsiom_shylau.collections.maintask.entities.impl.Wrapper;
import com.epam.training.artsiom_shylau.collections.maintask.exceptions.FloristException;
import com.epam.training.artsiom_shylau.collections.maintask.validation.FloristValidator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Florist {

    public static class Bouquet {
        private List<BouquetComponent> components = new ArrayList<>();

        public int getNumberOfComponents(){
           return components.size();
        }

        @Override
        public String toString() {
            return "Bouquet{" +
                    "components=" + components +
                    '}';
        }
    }

    public Bouquet collectBouquet(Wrapper wrapper, Postcard postcard, Flower... flowers) throws FloristException {
            FloristValidator.validateObjectNull(wrapper);
            FloristValidator.validateObjectNull(postcard);
            FloristValidator.validateFlowerArray(flowers);
            Bouquet bouquet = new Bouquet();
            bouquet.components.add(wrapper);
            bouquet.components.add(postcard);
            bouquet.components.addAll(List.of(flowers));
            return bouquet;
    }

    public Bouquet collectBouquet(Flower... flowers) throws FloristException {
            FloristValidator.validateFlowerArray(flowers);
            Bouquet bouquet = new Bouquet();
            bouquet.components.addAll(List.of(flowers));
            return bouquet;
    }

    public double countBouquetPrice(Bouquet bouquet) throws FloristException {
            FloristValidator.validateObjectNull(bouquet);
            if (bouquet.components.size() == 0) {
                return 0;
            }
            return bouquet.components.stream().mapToDouble(BouquetComponent::getPrice).sum();
    }

    Comparator<BouquetComponent> comparatorForSortingBouquetDaysAfterSlice = (o1, o2) -> {
        if (!(o1 instanceof Flower) && !(o2 instanceof Flower)) {
            return o1.getClass().getName().charAt(0) - o2.getClass().getName().charAt(0);
        }
        if ((o1 instanceof Flower) && (o2 instanceof Flower)) {
            return ((Flower) o1).getDaysAfterSlice() - ((Flower) o2).getDaysAfterSlice();
        }
        if (o1 instanceof Flower) {
            return 1;
        }
        return -1;
    };

    public void sortFlowersByDaysAfterSlice(Bouquet bouquet) throws FloristException {
            FloristValidator.validateObjectNull(bouquet);
            bouquet.components.sort(comparatorForSortingBouquetDaysAfterSlice);
    }

    public List<Flower> findFlowersByStemLength(Bouquet bouquet, double from, double to) throws FloristException {
        FloristValidator.validateObjectNull(bouquet);
        if (bouquet.components.size() == 0 || from < 0 || to < 0 || from > to) {
            return new ArrayList<>();
        }
        return bouquet.components.stream().filter(b -> ((b instanceof Flower)
                        && (((Flower) b).getStemLength() >= from && ((Flower) b).getStemLength() <= to)))
                .map(b -> (Flower) b)
                .collect(Collectors.toList());
    }
}

package com.epam.training.artsiom_shylau.fundamentals.main_task.third_point.util;

import com.epam.training.artsiom_shylau.fundamentals.main_task.exception.MainTaskException;

public class OutputOfNumbers {

    public int[] getArrayOfRandomNumbersFrom0To100(int amount) throws MainTaskException {
        if (amount <= 0) {
            throw new MainTaskException("parameter must be positive");
        }
        int[] randomNumbers = new int[amount];
        for (int i = 0; i < amount; i++) {
            randomNumbers[i] = (int) (Math.random() * 100 + 1);
        }
        return randomNumbers;
    }
}

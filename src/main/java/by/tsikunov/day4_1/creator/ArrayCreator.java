package by.tsikunov.day4_1.creator;

import by.tsikunov.day4_1.entity.NumberArray;
import by.tsikunov.day4_1.parser.DataParser;

import java.util.Random;

public class ArrayCreator {

    private static final int MAX_CAPACITY = 50;
    private static final int MAX_VALUE = 1000;
    private static final Random random = new Random();

    public NumberArray createRandomArray() {
        int capacity = random.nextInt(MAX_CAPACITY) + 1;
        NumberArray array = new NumberArray(capacity);
        for (int i = 0; i < capacity; i++) {
            array.set(i, random.nextInt(MAX_VALUE));
        }
        return array;
    }

    public NumberArray createArrayFromString(String arrayData) {
        DataParser parser = new DataParser();
        int[] array = parser.parseString(arrayData);
        return new NumberArray(array);
    }

}

package by.tsikunov.day4_1.creator;

import by.tsikunov.day4_1.entity.NumberArray;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayCreatorTest {

    @Test
    public void createRandomArrayTest() {
        ArrayCreator creator = new ArrayCreator();
        NumberArray actual = creator.createRandomArray();
        assertNotNull(actual);
    }
    @Test
    public void createRandomArrayLengthTest() {
        ArrayCreator creator = new ArrayCreator();
        NumberArray actual = creator.createRandomArray();
        assertTrue(actual.getLength() > 0 &&
                actual.getLength() <= ArrayCreator.MAX_CAPACITY);
    }

    @Test
    public void createArrayFromStringTest() {
        String arrayData = "1 6 9 7 4 2";
        ArrayCreator creator = new ArrayCreator();
        NumberArray actual = creator.createArrayFromString(arrayData);
        NumberArray expected = new NumberArray(new int[]{1, 6, 9, 7, 4, 2});
        assertEquals(actual, expected);
    }
}
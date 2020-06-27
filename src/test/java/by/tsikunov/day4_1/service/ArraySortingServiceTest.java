package by.tsikunov.day4_1.service;

import by.tsikunov.day4_1.entity.NumberArray;
import by.tsikunov.day4_1.exception.InvalidArrayDataException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArraySortingServiceTest {

    ArraySortingService service = new ArraySortingService();

    @Test
    public void testBubbleSort() {
        try {
            NumberArray array = new NumberArray(new int[]{1, 8, 5, 1, 9, 105, 666, 54, 345, 610});
            NumberArray expected = new NumberArray(new int[]{1, 1, 5, 8 , 9 , 54, 105, 345, 610, 666});
            service.bubbleSort(array);
            assertEquals(array, expected);
        } catch (Exception e) {
            fail("Error");
        }
    }
    @Test(expectedExceptions = InvalidArrayDataException.class,
            expectedExceptionsMessageRegExp = "Invalid entry array")
    public void testBubbleSortException() throws InvalidArrayDataException {
        service.bubbleSort(null);
    }

    @Test
    public void testInsertionSort() {
        try {
            NumberArray array = new NumberArray(new int[]{1, 8, 5, 1, 9, 105, 666, 54, 345, 610});
            NumberArray expected = new NumberArray(new int[]{1, 1, 5, 8 , 9 , 54, 105, 345, 610, 666});
            service.insertionSort(array);
            assertEquals(array, expected);
        } catch (Exception e) {
            fail("Error");
        }
    }
    @Test(expectedExceptions = InvalidArrayDataException.class,
            expectedExceptionsMessageRegExp = "Invalid entry array")
    public void testInsertionSortException() throws InvalidArrayDataException {
        service.insertionSort(null);
    }

    @Test
    public void testSelectionSort() {
        try {
            NumberArray array  = new NumberArray(new int[]{1, 8, 5, 1, 9, 105, 666, 54, 345, 610});
            NumberArray expected = new NumberArray(new int[]{1, 1, 5, 8 , 9 , 54, 105, 345, 610, 666});
            service.selectionSort(array);
            assertEquals(array, expected);
        } catch (Exception e) {
            fail("Error");
        }
    }
    @Test(expectedExceptions = InvalidArrayDataException.class,
            expectedExceptionsMessageRegExp = "Invalid entry array")
    public void testSelectionSortException() throws InvalidArrayDataException {
        service.selectionSort(null);
    }
}
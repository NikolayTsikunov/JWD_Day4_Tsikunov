package by.tsikunov.day4_2.service;

import by.tsikunov.day4_1.exception.InvalidArrayDataException;
import by.tsikunov.day4_2.enumerator.SortDirection;
import by.tsikunov.day4_2.enumerator.SortType;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SortJaggedArrayServiceTest {

    @Test(expectedExceptions = InvalidArrayDataException.class,
    expectedExceptionsMessageRegExp = "Incorrect jagged array")
    public void testBubbleSortException() throws InvalidArrayDataException {
        SortJaggedArrayService service = new SortJaggedArrayService();
        service.bubbleSort(null, SortDirection.INCREASING, SortType.MIN);
    }

    @Test
    public void testBubbleSortIncreasingSum() {
        int[][] array = new int[][] {{1, 6, 9, 4, 2, 0}, //22
                {6, 9, 4}, //19
                {8, 0, 5, 3, 2, 7, 0}, //25
                {1, 7, 5}}; //13

        SortJaggedArrayService service = new SortJaggedArrayService();
        int[][] expected = new int[][] {{1, 7, 5},
                {6, 9, 4},
                {1, 6, 9, 4, 2, 0},
                {8, 0, 5, 3, 2, 7, 0}};
        try {
            service.bubbleSort(array, SortDirection.INCREASING, SortType.SUM);
            assertEquals(array, expected);
        } catch (Exception e) {
            fail("Error");
        }
    }
    @Test
    public void testBubbleSortDiscreasingSum() {
        int[][] array = new int[][] {{1, 6, 9, 4, 2, 0}, //22
                {6, 9, 4}, //19
                {8, 0, 5, 3, 2, 7, 0}, //25
                {1, 7, 5}}; //13

        SortJaggedArrayService service = new SortJaggedArrayService();
        int[][] expected = new int[][] {{8, 0, 5, 3, 2, 7, 0},
                {1, 6, 9, 4, 2, 0},
                {6, 9, 4},
                {1, 7, 5}};
        try {
            service.bubbleSort(array, SortDirection.DISCREASING, SortType.SUM);
            assertEquals(array, expected);
        } catch (Exception e) {
            fail("Error");
        }
    }
    @Test
    public void testBubbleSortIncreasingMax() {
        int[][] array = new int[][] {{1, 6, 9, 4, 2, 0},
                {6, 18, 4},
                {8, 0, 13, 3, 2, 7, 0},
                {1, 7, 5}};

        SortJaggedArrayService service = new SortJaggedArrayService();
        int[][] expected = new int[][] {{1, 7, 5},
                {1, 6, 9, 4, 2, 0},
                {8, 0, 13, 3, 2, 7, 0},
                {6, 18, 4}};
        try {
            service.bubbleSort(array, SortDirection.INCREASING, SortType.MAX);
            assertEquals(array, expected);
        } catch (Exception e) {
            fail("Error");
        }
    }
    @Test
    public void testBubbleSortDiscreasingMax() {
        int[][] array = new int[][] {{1, 6, 9, 4, 2, 0},
                {6, 18, 4},
                {8, 0, 13, 3, 2, 7, 0},
                {1, 7, 5}};

        SortJaggedArrayService service = new SortJaggedArrayService();
        int[][] expected = new int[][] {{6, 18, 4},
                {8, 0, 13, 3, 2, 7, 0},
                {1, 6, 9, 4, 2, 0},
                {1, 7, 5}};
        try {
            service.bubbleSort(array, SortDirection.DISCREASING, SortType.MAX);
            assertEquals(array, expected);
        } catch (Exception e) {
            fail("Error");
        }
    }
    @Test
    public void testBubbleSortIncreasingMin() {
        int[][] array = new int[][] {{1, 6, -9, 4, 2, 0},
                {6, 18, -4},
                {8, 0, 13, -3, 2, 7, 0},
                {-1, 7, 5}};

        SortJaggedArrayService service = new SortJaggedArrayService();
        int[][] expected = new int[][] {{1, 6, -9, 4, 2, 0},
                {6, 18, -4},
                {8, 0, 13, -3, 2, 7, 0},
                {-1, 7, 5}};
        try {
            service.bubbleSort(array, SortDirection.INCREASING, SortType.MIN);
            assertEquals(array, expected);
        } catch (Exception e) {
            fail("Error");
        }
    }
    @Test
    public void testBubbleSortDiscreasingMin() {
        int[][] array = new int[][] {{1, 6, -9, 4, 2, 0},
                {6, 18, -4},
                {8, 0, 13, -3, 2, 7, 0},
                {-1, 7, 5}};

        SortJaggedArrayService service = new SortJaggedArrayService();
        int[][] expected = new int[][] {{-1, 7, 5},
                {8, 0, 13, -3, 2, 7, 0},
                {6, 18, -4},
                {1, 6, -9, 4, 2, 0}};
        try {
            service.bubbleSort(array, SortDirection.DISCREASING, SortType.MIN);
            assertEquals(array, expected);
        } catch (Exception e) {
            fail("Error");
        }
    }
}
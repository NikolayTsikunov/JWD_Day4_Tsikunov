package by.tsikunov.day4_2.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayValidatorTest {

    @Test
    public void testIsJaggedArrayValidPositive() {
        int[][] array = new int[][] {{1, 6, 9, 4, 2, 0},
                                     {6, 9, 4},
                                     {8, 0, 5, 3, 2, 7, 0},
                                     {1, 7, 5}};
        ArrayValidator validator = new ArrayValidator();
        boolean isJagged = validator.isJaggedArrayValid(array);
        assertTrue(isJagged);
    }
    @Test
    public void testIsJaggedArrayValidNegative() {
        int[][] array = new int[][] {{1, 6, 9, 4, 2, 0}};
        ArrayValidator validator = new ArrayValidator();
        boolean isJagged = validator.isJaggedArrayValid(array);
        assertFalse(isJagged);
    }
}
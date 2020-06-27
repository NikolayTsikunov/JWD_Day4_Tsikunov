package by.tsikunov.day4_1.service;

import by.tsikunov.day4_1.entity.NumberArray;
import by.tsikunov.day4_1.exception.InvalidArrayDataException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArraySeekerServiceTest {

    ArraySeekerService service;
    NumberArray array;

    @BeforeTest
    private void setUpData() {
        service = new ArraySeekerService();
        array = new NumberArray(new int[]{1, 8, 5, 1, 9, 105, 666, 54, 345});
    }

    @Test
    public void testMinElement() {
        try {
            int expected = 1;
            int actual = service.minElement(array);
            assertEquals(actual, expected);
        } catch (InvalidArrayDataException e) {
            fail("Error");
        }
    }

    @Test(expectedExceptions = InvalidArrayDataException.class,
    expectedExceptionsMessageRegExp = "Invalid entry array")
    public void testMinElementException() throws InvalidArrayDataException {
        service.minElement(null);
    }

    @Test
    public void testMaxElement() {
        try {
            int expected = 666;
            int actual = service.maxElement(array);
            assertEquals(actual, expected);
        } catch (InvalidArrayDataException e) {
            fail("Error");
        }
    }
    @Test(expectedExceptions = InvalidArrayDataException.class,
            expectedExceptionsMessageRegExp = "Invalid entry array")
    public void testMaxElementException() throws InvalidArrayDataException {
        service.maxElement(null);
    }

    @Test
    public void testFindFibonacciNumbers() {
        try {
            array = new NumberArray(new int[]{1, 8, 5, 1, 9, 105, 666, 54, 345, 610});
            NumberArray expected = new NumberArray(new int[]{1, 8, 5, 1, 610});
            NumberArray actual = service.findFibonacciNumbers(array);
            assertEquals(actual, expected);
        } catch (Exception e) {
            fail("Error");
        }
    }
    @Test(expectedExceptions = InvalidArrayDataException.class,
            expectedExceptionsMessageRegExp = "Invalid entry array")
    public void testFindFibonacciNumbersException() throws InvalidArrayDataException {
        service.findFibonacciNumbers(null);
    }

    @Test
    public void testFindSimpleNumbers() {
        try {
            array = new NumberArray(new int[]{1, 8, 5, 1, 9, 105, 666, 54, 345, 610, 13, 7});
            NumberArray expected = new NumberArray(new int[]{5, 13, 7});
            NumberArray actual = service.findSimpleNumbers(array);
            assertEquals(actual, expected);
        } catch (Exception e) {
            fail("Error");
        }
    }
    @Test(expectedExceptions = InvalidArrayDataException.class,
            expectedExceptionsMessageRegExp = "Invalid entry array")
    public void testFindSimpleNumbersException() throws InvalidArrayDataException {
        service.findSimpleNumbers(null);
    }

    @Test
    public void testFindUniqueThreeDigitNumbers() {
        try {
            array = new NumberArray(new int[]{1, 8, 5, 1, 9, 105, 666, 54, 345, 610, 13, 7});
            NumberArray expected = new NumberArray(new int[]{105, 345, 610});
            NumberArray actual = service.findUniqueThreeDigitNumbers(array);
            assertEquals(actual, expected);
        } catch (Exception e) {
            fail("Error");
        }
    }
    @Test(expectedExceptions = InvalidArrayDataException.class,
            expectedExceptionsMessageRegExp = "Invalid entry array")
    public void testFindUniqueThreeDigitNumbersException() throws InvalidArrayDataException {
        service.findUniqueThreeDigitNumbers(null);
    }

    @Test
    public void testBinarySearch() {
        try {
            array = new NumberArray(new int[]{1, 5, 6, 8, 10, 55, 109, 630, 799});
            int expected = 6;
            int actual = service.binarySearch(array, 109);
            assertEquals(actual, expected);
        } catch (Exception e) {
            fail("Error");
        }
    }
    @Test(expectedExceptions = InvalidArrayDataException.class,
            expectedExceptionsMessageRegExp = "Invalid entry array")
    public void testBinarySearchException() throws InvalidArrayDataException {
        array = new NumberArray(new int[]{1, 8, 5, 1, 9, 105, 666, 54, 345, 610, 13, 7});
        service.binarySearch(array, 666);
    }
}
package by.tsikunov.day4_1.parser;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DataParserTest {

    @Test
    public void parseStringTest() {
        DataParser parser = new DataParser();
        String data = "1 6 9 7 4 2";
        int[] actual = parser.parseString(data);
        int[] expected = {1, 6, 9, 7, 4, 2};
        assertEquals(actual, expected);
    }
}
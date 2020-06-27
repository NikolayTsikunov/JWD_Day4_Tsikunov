package by.tsikunov.day4_1.reader;

import by.tsikunov.day4_1.exception.InvalidArrayDataException;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ArrayReaderTest {

    @Test
    public void readFileDataTest() {
        ArrayReader reader = new ArrayReader();
        List<String> actual = reader.readFileData(
                "src/main/resources/data/arrayData");
        List<String> expected = new ArrayList<>();
        expected.add("1 2 3 8 4 7 9 6");
        expected.add("8 9 4 7 3 6 5 7");
        assertEquals(actual, expected);
    }


    @Test
    public void readConsoleDataTest() {
        ArrayReader reader = new ArrayReader();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("5").append('\n');
            sb.append("1").append('\n');
            sb.append("2").append('\n');
            sb.append("5").append('\n');
            sb.append("4").append('\n');
            sb.append("5").append('\n');
            InputStream inputStream = new ByteArrayInputStream(sb.toString().getBytes());
            InputStream defaultInputStream = System.in;
            System.setIn(inputStream);
            String actual = reader.readConsoleData();
            inputStream.close();
            String expected = "1 2 5 4 5";
            assertEquals(actual, expected);
        } catch (InvalidArrayDataException | IOException e) {
            fail(e.getMessage());
        }
    }
}
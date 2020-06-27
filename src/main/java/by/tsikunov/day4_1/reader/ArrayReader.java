package by.tsikunov.day4_1.reader;

import by.tsikunov.day4_1.exception.InvalidArrayDataException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ArrayReader {

    private static final String DEFAULT_PATH = "src/main/resources/data/arrayData";

    public List<String> readFileData(String filePath) {
        Path path = Paths.get(DEFAULT_PATH);
        List<String> lines;

        if(filePath != null) {
            if(Files.exists(Paths.get(filePath))) {
                path = Paths.get(filePath);
            }
        }

        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file");
        }

        return lines;
    }

    public String readConsoleData() throws InvalidArrayDataException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        try {
            System.out.println("Input array capacity:");
            int arrayCapacity = Integer.parseInt(reader.readLine());
            System.out.println("Input array elements:");
            for (int i = 0; i < arrayCapacity; i++) {
                sb.append(reader.readLine());
                if(i < (arrayCapacity - 1)) {
                    sb.append(" ");
                }
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            throw new InvalidArrayDataException("Error while reading from console.");
        }

        return sb.toString();
    }
}

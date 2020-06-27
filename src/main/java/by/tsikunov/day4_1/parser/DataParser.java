package by.tsikunov.day4_1.parser;

public class DataParser {

    private final static String REGEX_SPLIT = " ";

    public int[] parseString(String string) {
        String[] stringElements = string.split(REGEX_SPLIT);
        int[] array = new int[stringElements.length];

        for (int i = 0; i < stringElements.length; i++) {
            array[i] = Integer.parseInt(stringElements[i]);
        }
        return array;
    }

}

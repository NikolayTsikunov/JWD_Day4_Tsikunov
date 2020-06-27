package by.tsikunov.day4_2.validator;

public class ArrayValidator {
    public boolean isJaggedArrayValid(int[][] array) {
        boolean result = true;
        if (array == null || array.length < 2){
            result = false;
        } else {
            for (int[] ints : array) {
                if (ints == null || ints.length <= 0) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}

package by.tsikunov.day4_1.service;

import by.tsikunov.day4_1.entity.NumberArray;
import by.tsikunov.day4_1.exception.InvalidArrayDataException;

import java.util.List;

public class ArraySeekerService {

    public int minElement(NumberArray array) throws InvalidArrayDataException {
        if(array == null || array.getLength() == 0) {
            throw new InvalidArrayDataException("Invalid entry array");
        }
        int min = array.get(0).getAsInt();
        for (int i = 1; i < array.getLength(); i++) {
            if(array.get(i).getAsInt() < min) {
                min = array.get(i).getAsInt();
            }
        }
        return min;
    }

    public int maxElement(NumberArray array) throws InvalidArrayDataException {
        if(array == null || array.getLength() == 0) {
            throw new InvalidArrayDataException("Invalid entry array");
        }
        int max = array.get(0).getAsInt();
        for (int i = 1; i < array.getLength(); i++) {
            if(array.get(i).getAsInt() > max) {
                max = array.get(i).getAsInt();
            }
        }
        return max;
    }

    public NumberArray findFibonacciNumbers(NumberArray array) throws InvalidArrayDataException {
        if(array == null || array.getLength() == 0) {
            throw new InvalidArrayDataException("Invalid entry array");
        }
        int[] fibonacci = new int[array.getLength()];
        int findIndex = 0;

        for (int i = 0; i < array.getLength(); i++) {
            if(array.get(i).getAsInt() == 0 || array.get(i).getAsInt() == 1) {
                fibonacci[findIndex] = array.get(i).getAsInt();
                findIndex++;
            }

            int previous = 0;
            int next = 1;
            int sum;
            while (next < array.get(i).getAsInt()) {
                sum = previous + next;
                previous = next;
                next = sum;
                if(sum == array.get(i).getAsInt()) {
                    fibonacci[findIndex] = array.get(i).getAsInt();
                    findIndex++;
                }
            }
        }

        NumberArray fibonacciNumbers = new NumberArray(findIndex);
        for (int i = 0; i < findIndex; i++) {
            fibonacciNumbers.set(i, fibonacci[i]);
        }
        return fibonacciNumbers;
    }

    public NumberArray findSimpleNumbers(NumberArray array) throws InvalidArrayDataException {
        if(array == null || array.getLength() == 0) {
            throw new InvalidArrayDataException("Invalid entry array");
        }
        int[] simpleNumbers = new int[array.getLength()];
        int index = 0;

        for (int i = 0; i < array.getLength(); i++) {
            int number = array.get(i).getAsInt();
            boolean simple = true;
            for (int divider = 2; divider <= number; divider++) {
                if(number % divider == 0 && divider != number) {
                    simple = false;
                    break;
                }
            }
            if(simple && number > 1) {
                simpleNumbers[index] = number;
                index++;
            }
        }
        NumberArray result = new NumberArray(index);
        for (int i = 0; i < index; i++) {
            result.set(i, simpleNumbers[i]);
        }
        return result;
    }

    public NumberArray findUniqueThreeDigitNumbers(NumberArray array) throws InvalidArrayDataException {
        if(array == null || array.getLength() == 0) {
            throw new InvalidArrayDataException("Invalid entry array");
        }
        String number;
        int[] treeDigit = new int[array.getLength()];
        int index = 0;

        for (int i = 0; i < array.getLength(); i++) {
            number = String.valueOf(array.get(i).getAsInt());
            if(number.length() == 3) {
                char[] digits = number.toCharArray();
                if(digits[0] != digits[1] && digits[1] != digits[2] && digits[0] != digits[2]) {
                    treeDigit[index] = array.get(i).getAsInt();
                    index++;
                }
            }
        }

        NumberArray result = new NumberArray(index);
        for (int i = 0; i < result.getLength(); i++) {
            result.set(i, treeDigit[i]);
        }
        return result;
    }

    public int binarySearch(NumberArray array, int key) throws InvalidArrayDataException {
        if(array == null || !isSorted(array)) {
            throw new InvalidArrayDataException("Invalid entry array");
        }
        int maxIndex = array.getLength() - 1;
        int minIndex = 0;
        int index = -1;

        while (minIndex <=maxIndex) {
            int midIndex = (minIndex + maxIndex) / 2;
            if(array.get(midIndex).getAsInt() < key) {
                minIndex = midIndex + 1;
            } else if(array.get(midIndex).getAsInt() > key) {
                maxIndex = midIndex - 1;
            } else {
                index = midIndex;
                break;
            }
        }
        return index;
    }

    private boolean isSorted(NumberArray array) {
        for (int i = 0; i < array.getLength() - 1; i++) {
            if(array.get(i).getAsInt() > array.get(i+1).getAsInt()) {
                return false;
            }
        }
        return true;
    }

}

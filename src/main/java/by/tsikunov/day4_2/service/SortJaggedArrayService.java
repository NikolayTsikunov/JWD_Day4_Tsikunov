package by.tsikunov.day4_2.service;

import by.tsikunov.day4_1.exception.InvalidArrayDataException;
import by.tsikunov.day4_2.enumerator.SortDirection;
import by.tsikunov.day4_2.enumerator.SortType;
import by.tsikunov.day4_2.validator.ArrayValidator;

public class SortJaggedArrayService {
    public void bubbleSort(int[][] array, SortDirection dir, SortType type) throws InvalidArrayDataException {
        ArrayValidator validator = new ArrayValidator();
        if(!validator.isJaggedArrayValid(array)) {
            throw new InvalidArrayDataException("Incorrect jagged array");
        }
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                int firstBubble = sortOption(array[i], type);
                int secondBubble = sortOption(array[i+1], type);
                if((firstBubble - secondBubble) * dir.getDirection() > 0) {
                    swap(array, i, i + 1);
                    sorted = false;
                }
            }
        }
    }

    private int sortOption(int[] array, SortType type) {
        int option;
        if(type == SortType.SUM) {
            option = sum(array);
        } else {
            option = minMax(array, type);
        }
        return option;
    }

    private int sum(int[] array) {
        int result = 0;
        for(int i : array) {
            result += i;
        }
        return result;
    }

    private int minMax(int[] array, SortType type) {
        int minMAX = array[0];
        for (int i = 1; i < array.length; i++) {
            if((minMAX < array[i] && type == SortType.MAX) ||
                    (minMAX > array[i] && type == SortType.MIN)) {
                minMAX = array[i];
            }
        }
        return minMAX;
    }

    private void swap(int[][] array, int first, int second) {
        int[] temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}

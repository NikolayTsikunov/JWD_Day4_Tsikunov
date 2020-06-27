package by.tsikunov.day4_1.service;

import by.tsikunov.day4_1.entity.NumberArray;
import by.tsikunov.day4_1.exception.InvalidArrayDataException;

public class ArraySortingService {

    public void bubbleSort(NumberArray array) throws InvalidArrayDataException {
        if(array == null) {
            throw new InvalidArrayDataException("Invalid entry array");
        }
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.getLength() - 1; i++) {
                if(array.get(i).getAsInt() > array.get(i + 1).getAsInt()) {
                    swap(array, i, i+1);
                    sorted = false;
                }
            }
        }
    }

    public void insertionSort(NumberArray array) throws InvalidArrayDataException {
        if(array == null) {
            throw new InvalidArrayDataException("Invalid entry array");
        }
        for (int i = 0; i < array.getLength(); i++) {
            int current = array.get(i).getAsInt();
            int j = i - 1;
            while (j >= 0 && current < array.get(j).getAsInt()) {
                array.set(j+1, array.get(j).getAsInt());
                j--;
            }
            array.set(j+1, current);
        }
    }

    public void selectionSort(NumberArray array) throws InvalidArrayDataException {
        if(array == null) {
            throw new InvalidArrayDataException("Invalid entry array");
        }
        for (int i = 0; i < array.getLength(); i++) {
            int min = array.get(i).getAsInt();
            int minId = i;
            for (int j = i+1; j < array.getLength(); j++) {
                if(array.get(j).getAsInt() < min) {
                    min = array.get(j).getAsInt();
                    minId = j;
                }
            }
            swap(array, i, minId);
        }
    }

    private void swap(NumberArray array, int first, int second) {
        int temp = array.get(first).getAsInt();
        array.set(first, array.get(second).getAsInt());
        array.set(second, temp);
    }


}

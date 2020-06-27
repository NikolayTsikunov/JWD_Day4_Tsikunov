package by.tsikunov.day4_1.entity;

import java.util.OptionalInt;

public class NumberArray {

    private static final int DEFAULT_SIZE = 10;
    private int[] array;

    public NumberArray() {
        this.array = new int[DEFAULT_SIZE];
    }

    public NumberArray(int size) {
        if(size > 0) {
            this.array = new int[size];
        } else {
            this.array = new int[DEFAULT_SIZE];
        }
    }

    public NumberArray(int[] array) {
        if(array != null && array.length > 0) {
            this.array = array;
        } else {
            this.array = new int[DEFAULT_SIZE];
        }
    }

    public boolean fillArray(int[] array) {
        boolean result = false;
        if(array != null && array.length > 0) {
            this.array = array;
            result = true;
        }
        return result;
    }

    public OptionalInt get(int index) {
        if(index >= 0 && index < array.length) {
            return OptionalInt.of(array[index]);
        } else {
            return OptionalInt.empty();
        }
    }

    public boolean set(int index, int number) {
        if(index < 0 || index > array.length - 1) {
            return false;
        }
        array[index] = number;
        return true;
    }

    public int getLength() {
        return this.array.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("NumberArray{ ").append("array=");
        sb.append("[ ");
        for(int value : array) {
            sb.append(value).append(" ");
        }
        sb.append("]}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        NumberArray entryObj = (NumberArray) obj;

        if(entryObj.array.length != this.array.length) {
            return false;
        }
        boolean result = true;
        for (int i = 0; i < entryObj.array.length; i++) {
            if(entryObj.array[i] != this.array[i]) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int value : this.array) {
            result = 31 * result + value;
        }
        return result;
    }
}

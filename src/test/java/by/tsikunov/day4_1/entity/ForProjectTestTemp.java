package by.tsikunov.day4_1.entity;

import org.testng.annotations.Test;
import java.util.OptionalInt;

public class ForProjectTestTemp {

    @Test
    public void NumberArray() {
        int[] array = new int[10];
        System.out.println(array[0]);
        System.out.println(array[1]);

        NumberArray array1 = new NumberArray();
        System.out.println(array1.toString());
    }

}
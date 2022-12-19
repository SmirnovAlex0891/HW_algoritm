package hw_17_12_2022;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex2 {
    public static void main(String[] args) {
        int[] arr1 = {100, 112, 256, 349, 770};
        int[] arr2 = {72, 86, 113, 119, 265, 445, 892};
        int f = 16;

        System.out.println(mergeAndFind(arr1, arr2, f));

    }

    public static int mergeAndFind(int[] arr1, int[] arr2, int f) {
        int findEl = 0;
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0;
        for (; i < arr1.length && j < arr2.length; ) {
            if (arr1[i] < arr2[j]) {
                if (f == 1)
                    findEl = arr1[i];
                f--;
                result[i + j] = arr1[i];
                i++;
            } else {
                if (f == 1)
                    findEl = arr2[j];
                f--;
                result[i + j] = arr2[j];
                j++;
            }
        }
        for (int k = i; k < arr1.length; k++) {
            if (f == 1)
                findEl = arr1[k];
            f--;
            result[k + j] = arr1[k];
        }
        for (int k = j; k < arr2.length; k++) {
            if (f == 1)
                findEl = arr2[k];
            f--;
            result[k + i] = arr2[k];
        }
        return findEl;
    }
}

package hw_22_03_2023;

/**
 * Имея два отсортированных массива размера m и n соответственно, вам нужно найти элемент, который будет
 * находиться на k-й позиции в конечном отсортированном массиве.
 * Массив 1 - 100 112 256 349 770
 * Массив 2 - 72 86 113 119 265 445 892
 * к = 7
 * Вывод : 256
 * Окончательный отсортированный массив -
 * 72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
 * 7-й элемент этого массива равен 256.
 */
public class hw2 {
    public static void main(String[] args) {
        int[] arr1 = {100, 112, 256, 349, 770};
        int[] arr2 = {72, 86, 113, 119, 265, 445, 892};
        int k = 7;
        System.out.println(searchEl(arr1, arr2, k));
    }

    public static int searchEl(int[] arr1, int[] arr2, int k) {
        int a = 0;
        int b = 0;
        int result = -1;
        int[] res = new int[arr1.length + arr2.length];
        for (int i = 0; i < res.length; i++) {
            if (a < arr1.length && b < arr2.length) {
                if (arr1[a] < arr2[b]) {
                    res[i] = arr1[a++];
                } else {
                    res[i] = arr2[b++];
                }
            } else if (a == arr1.length) {
                res[i] = arr2[b++];
            } else res[i] = arr1[a++];

            if (i + 1 == k) result = res[i];
        }
        return result;
    }
}

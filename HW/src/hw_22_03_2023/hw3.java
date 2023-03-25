package hw_22_03_2023;

/**
 * Имея отсортированный массив arr[] и число x, напишите функцию, которая подсчитывает вхождения x в arr[].
 * Ожидаемая временная сложность O(Log n)
 * arr[] = {1, 1, 2, 2, 2, 2, 3,}
 * x = 2
 * Вывод: 4 раза
 */
public class hw3 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int x = 2;
        System.out.println(numberOfEl(arr, x));
    }

    public static int numberOfEl(int[] arr, int x) {
        //System.out.println(searchTop(arr, x));
        //System.out.println(searchBottom(arr, x));
        return 1 + searchTop(arr, x) - searchBottom(arr, x);
    }

    public static int searchTop(int[] arr, int x) {
        int first = 0;
        int last = arr.length - 1;

        while (first <= last) {
            int middle = (first + last) / 2;

            if (middle == last && arr[middle] == x) {
                return middle;
            } else if (arr[middle] == x && arr[middle + 1] > x) {
                return middle;
            } else if (arr[middle] <= x) {
                first = middle + 1;
            } else if (arr[middle] > x) {
                last = middle - 1;
            }
        }
        return -1;
    }

    public static int searchBottom(int[] arr, int x) {
        int first = 0;
        int last = arr.length - 1;

        while (first <= last) {
            int middle = (first + last) / 2;

            if (middle == first && arr[middle] == x) {
                return middle;
            } else if (arr[middle] == x && arr[middle - 1] < x) {
                return middle;
            } else if (arr[middle] < x) {
                first = middle + 1;
            } else if (arr[middle] >= x) {
                last = middle - 1;
            }
        }
        return -1;
    }
}

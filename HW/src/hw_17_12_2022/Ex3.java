package hw_17_12_2022;

public class Ex3 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int el = 2;

        int index = arr.length / 2;

        System.out.println(findNumEl(arr, el, index));
    }

    public static int findNumEl(int[] arr, int el, int index) {
        int top = arr.length - 1;
        int indEl = findEl(arr, el, index, top);

        int indMax = findMax(arr, indEl, el);

        int indMin = findMin(arr, indEl, el);

        return indMax - (indMin - 1);
    }

    public static int findEl(int[] arr, int el, int index, int top) {
        int indEl = index;
        if (arr[index] == el)
            return indEl;
        else if (arr[index] > el) {
            index = index / 2;
            indEl = findEl(arr, el, index, top);
        } else if (arr[index] < el || index == top) {
            if ((top - index) == 1) {
                index = index + (top - index);
            } else {
                index = index + (top - index) / 2;
            }
            indEl = findEl(arr, el, index, top);
        }
        return indEl;
    }


    public static int findMax(int[] arr, int index, int el) {
        int indMax = index;
        if (index == arr.length - 1) {
            return indMax;
        }
        if (arr[index + 1] > el)
            return indMax;
        indMax = findMax(arr, index + 1, el);
        return indMax;
    }

    public static int findMin(int[] arr, int index, int el) {
        int indMin = index;
        if (index == 1 && arr[index - 1] == el) {
            return indMin = index - 1;
        } else {
            if (arr[index - 1] < el) {
                return indMin;
            } else {
                indMin = findMin(arr, index - 1, el);
            }
        }
        return indMin;
    }
}

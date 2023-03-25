package hw_22_03_2023;

/**
 * Найдите пиковый элемент в двумерном массиве
 * Элемент является пиковым, если он больше или равен своим четырем соседям слева, справа, сверху и снизу.
 * Например, соседями для A[i][j] являются A[i-1][j], A[i+1][j], A[i][j-1] и A[i][j+1 ].
 * Для угловых элементов отсутствующие соседи считаются отрицательными бесконечными значениями.
 * 10 20 15
 * 21 30 14
 * 7 16 32
 * Выход: 30
 * 30 — пиковый элемент, потому что все его
 * соседи меньше или равны ему.
 * 32 также можно выбрать в качестве пика.
 * <p>
 * <p>
 * note
 * 1 Смежная диагональ не считается соседней.
 * 2 Пиковый элемент не обязательно является максимальным элементом.
 * 3 Таких элементов может быть несколько.
 * 4 Всегда есть пиковый элемент.
 */
public class hw4 {
    public static void main(String[] args) {
        int[][] arr = {{10, 20, 15, 22}, {21, 30, 14, 23}, {7, 16, 32, 17}, {11, 22, 25, 38}};

        peakEl(arr);
    }

    public static void peakEl(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (isPeak(arr, j, i)) {
                    System.out.println("Peak: " + arr[i][j]);
                }
            }
        }
    }

    public static boolean isPeak(int[][] arr, int x, int y) {
        if (arr[y][x] < upper(arr, x, y)) return false;
        if (arr[y][x] < lower(arr, x, y)) return false;
        if (arr[y][x] < left(arr, x, y)) return false;
        if (arr[y][x] < right(arr, x, y)) return false;
        return true;
    }

    public static int upper(int[][] arr, int x, int y) {
        if (y == 0) return Integer.MIN_VALUE;
        return arr[y - 1][x];
    }

    public static int lower(int[][] arr, int x, int y) {
        if (y == arr.length - 1) return Integer.MIN_VALUE;
        return arr[y + 1][x];
    }

    public static int left(int[][] arr, int x, int y) {
        if (x == 0) return Integer.MIN_VALUE;
        return arr[y][x - 1];
    }

    public static int right(int[][] arr, int x, int y) {
        if (x == arr[y].length - 1) return Integer.MIN_VALUE;
        return arr[y][x + 1];
    }
}

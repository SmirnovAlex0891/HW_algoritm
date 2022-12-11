package less_08_12_2022;

public class Test1 {
    public static void main(String[] args) {
        int[] arr1 = {2, 5, 6};
        int[] arr2 = {3, 4, 7};
        int n = arr1.length;
        int m = arr2.length;

        int[] result = new int[n + m];



        int i = 0, j = 0;
        for (; i < arr1.length && j < arr2.length;) {
            if (arr1[i] < arr2[j]) {
                result[i+j] = arr1[i];
                i++;
            }else {
                result[i+j] = arr2[j];
                j++;
            }
        }
        for (int k = i; k < n; k++) {
            result[k+j] = arr1[k];
        }

        for (int k = j; k < m; k++) {
            result[k+i] = arr2[k];
        }

        for (int h = 0; h < result.length; h++) {
            System.out.println(result[i]);
        }

    }
}

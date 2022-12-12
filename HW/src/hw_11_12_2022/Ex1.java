package hw_11_12_2022;

public class Ex1 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 7, 8, 9, 12, 15};
        int key = 15;
        int ind = 0;
        System.out.println(binFind(arr, key, ind));
    }

    static int binFind(int[] arr, int key, int ind) {
        if (arr.length == 1) {
           return 0;
        }
        int a = arr[(arr.length / 2) - 1];
        if (a == key) {
            return arr.length / 2 - 1;

        } else {
            if (a < key) {
                ind = arr.length / 2;
                int[] n_arr = new int[arr.length / 2];
                for (int i = 0; i < n_arr.length; i++) {
                    n_arr[i] = arr[arr.length / 2 + i];
                    //System.out.println(n_arr[i]);
                }
                ind += binFind(n_arr, key, ind);
            } else {
                int[] n_arr = new int[arr.length / 2];
                for (int i = 0; i < n_arr.length; i++) {
                    n_arr[i] = arr[i];
                    //System.out.println(n_arr[i]);
                }
                ind = binFind(n_arr, key, ind);
            }
        }
        return ind;
    }
}


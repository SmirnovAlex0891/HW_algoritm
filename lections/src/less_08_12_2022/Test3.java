package less_08_12_2022;

public class Test3 {
    public static void main(String[] args) {
        int[] arr = {5,8,11,3,8,7,13,2,6};
        regrouping(arr);


    }

    // Quick sort
    // input arr of integers
    // out sorted arr

    // choose base element (how to choose - open question)
    // we can choose always first element, last element, random
    // divide it two parts:
    // in left part all elements which less than base element
    // in right part all elements which greater than base element

    // repeat recursively for each half

    // arr [5,8,11,3,8,7,13,2,6]
    // base element = 6
    // left [5,3,2], right = [8,11,8,7,13] =>  [5,3,2,6,8,11,8,7,13] - base element is in place
    // base 2: left [] right [5,3]; base 13 - left [8,11,8,7] =>   [2,5,3,6,8,11,8,7,13]
    // base 3 [5]; base 7 right [8,11,8] =>  [2,3,5,6,7,8,11,8,13]
    // base 8 right [8,11] =>  [2,3,5,6,7,8,11,8,13]
    // base 11 => [2,3,5,6,7,8,8,11,13]

    private static void regrouping(int[] arr) {
        int n = arr.length;
        int base = arr[n-1];
        int j = 0;
        for (int i = j; i < n; i++) {
            if(arr[i] <= base) {
                j++;

                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }

        }
    }
}

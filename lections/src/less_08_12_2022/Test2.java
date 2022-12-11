package less_08_12_2022;

public class Test2 {
    public static void main(String[] args) {
        int arr[] = {70, 250, 50, 300, 1};
        System.out.println(getMaxElement(arr, 0));


    }
    static int getMaxElement(int arr[], int index)
    {
        int max;
        int length = arr.length;

        if (length > index) {
            max = getMaxElement(arr, index + 1);

            if (arr[index] > max) {
                return arr[index];
            } else {
                return max;
            }
        }else {
            return arr[index - 1];
        }
// arr = [4,5,7,2], length = 4
        // getMaxElement(arr, 0), max - ?, index = 0
        //      getMaxElement(arr, 1) max - ?, index = 1
        //          getMaxElement(arr, 2) max - ? , index = 2
        //              getMaxElement(arr, 3) max - ?,index = 3
        //                  getMaxElement(arr, 4), index = 4
        //                  length > 4 => false
        //                  return 2 (arr[3])
        //              max = 2, arr[3] =2
        //              return 2
        //          2 < 7 (7 = arr[2])
        //          return 7
        //      7 > 5 (5 = arr[1])
        //      return 7
        // 7> 4 ( 4 = arr[0])
        // return 7


    }
}

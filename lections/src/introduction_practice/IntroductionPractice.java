package introduction_practice;

public class IntroductionPractice {
    public static void main(String[] args) {
         int[] arr = {1,2,3,4,5,6,7};
         int number = 5;

        int result = searchNumber(arr, number);

        printResult(result);

    }

    private static void printResult(int result) {
        if (result == -1) {
            System.out.println("number not found");
        }else {
            System.out.println("number of index = " + result);
        }
    }

    private static int searchNumber(int[] arr, int number) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {

            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }
}

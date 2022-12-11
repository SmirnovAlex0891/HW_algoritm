package less_24_11_2022;

public class Test {
    public static void main(String[] args) {

            int a = 22;
            int b = 21;
            getGCDEuklid(a, b);

            int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            printStars7(arr);


        }

        public static int getGCDEuklid(int a, int b) {
            while (b != 0) {
                int tmp = a % b;
                a = b;
                b = tmp;
                System.out.println("a = " + a + " b = " + b);
            }
            return a;
        }

        public static void printStars7(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }


    }
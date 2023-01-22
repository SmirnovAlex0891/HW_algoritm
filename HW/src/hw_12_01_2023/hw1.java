package hw_12_01_2023;

public class hw1 {
    public static void main(String[] args) {

        System.out.println(taskRecurs(40));
        System.out.println(taskOpt(40));
    }
    static  int x4 = 0;
    static  int x1 = 0;
    static  int x2 = 0;
    static  int x3 = 0;
    private static int taskRecurs(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;


        return taskRecurs(n-1) + taskRecurs(n-2) + taskRecurs(n-3);
    }
    private static int taskOpt(int n) {
        int n0 = 0;
        int n1 = 1;
        int n2 = 2;
        int n3 = 4;
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        for (int i = 4; i <= n ; i++) {
            n0 = n1 + n2 + n3;
            n1 = n2;
            n2 = n3;
            n3 = n0;
        }
        return n0;
    }
}

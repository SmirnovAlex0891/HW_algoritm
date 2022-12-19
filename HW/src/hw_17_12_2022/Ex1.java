package hw_17_12_2022;

public class Ex1 {
    public static void main(String[] args) {
       int x = 2;
       int n = 8;

        System.out.println(Exp(x, n));

    }

    public static int Exp(int x, int n) {

        if (n == 1) {
            return x;
        } else {
            x = x * (Exp(x, n-1));
        }
        return x;
    }
}


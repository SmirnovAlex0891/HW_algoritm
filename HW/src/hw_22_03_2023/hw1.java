package hw_22_03_2023;

/**
 * Даны два целых числа x и n, напишите функцию для вычисления x^n
 *      решение 1 - рекурсивно O(n)
 *      решение 2 - улучшить решение 1 до O(lon n)
 */
public class hw1 {
    public static void main(String[] args) {
        int n = 15;
        long x = 5;

        System.out.println(exponentiationRec(x, n));
        System.out.println(exponentiationTwo(x, n, 1));
    }

    public static long exponentiationRec(long x, int n) {
        if (n == 1) return x;
        return x * exponentiationRec(x, n - 1);
    }

    public static long exponentiationTwo(long x, int n, long res) {
        if (n == 0) {
            return res;
        } else {
            if (n % 2 == 1) {
                return exponentiationTwo(x, n - 1, res * x);
            } else {
                return exponentiationTwo(x * x, n / 2, res);
            }
        }
    }
}

package less_01_11_2022;

public class test {
    public static void main(String[] args) {
        // push(3) => [3] , [3,null,null,null,null,null], currIdx = 1
// push(6) => [6] , [3,6,null,null,null,null], currIdx = 2
// push(9) => [9] , [3,6,9,null,null,null], currIdx = 3
// pop() => [3,6,null,null,null,null], currIdx = 2

// if we start with currIdx = length -1
// push(7) => [null,null,null,null,null,7]
// push(9) => [null,null,null,null,9,7]

        class Stack {

            private Integer[] arr;
            // [null,null,null,null,null,null] if length = 6 (java point of view
            // []
            private int currIdx = 0;

            public Stack(int length) {
                this.arr = new Integer[length];
            }

            public void push(int elem) {
                arr[currIdx] = elem;
                currIdx++;
            }

            public int pop() {
                currIdx--;
                int elem = arr[currIdx];
                arr[currIdx] = null;
                return elem;
            }

        }
// stack
        // operations
        // push ~ O(1) - add element to stack
        // pop ~ O(1) - removes and retrieves an element from stack
        // isEmpty ~ O(1) - check is stack empty
        // peek ~ O(1) - retrieves an element from stack

    }
    public static int countConsonantRecursion(String str){
        int count = 0;
        int a = str.length();
        if (isConsonant(str.charAt(0))) {
            count++;
        }
        return count;
    }

    private static boolean isConsonant(char ch) {
        char letter = Character.toUpperCase(ch);
        return letter == 'A' ||
                letter == 'E' ||
                letter == 'I'||
                letter == 'O' ||
                letter == 'U';

    }
    static int functionRecursionNonTail(int n) {
        if (n == 0) {
            return n;
        } else {
            return n + functionRecursionNonTail(n - 1);
        }
    }

    static int functionRecursionTail(int n, int res) {
        if (n == 0) {
            return res;
        } else {
            return functionRecursionTail(n - 1, res + n);
        }
    }


}

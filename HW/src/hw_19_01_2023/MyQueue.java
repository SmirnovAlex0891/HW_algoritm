package hw_19_01_2023;

public class MyQueue {

    private int[] arr;      // массив для хранения элементов queue
    private int head;      // head указывает на передний элемент в queue
    private int tail;       // tail часть указывает на последний элемент в queue
    private int capacity;   // максимальная емкость queue
    private int count;      // текущий размер queue

    public MyQueue(int size) {
        arr = new int[size];
        capacity = size;
        head = 0;
        tail = -1;
        count = 0;
    }

    public void pushToEnd(int data) {
        if (count == capacity) throw new RuntimeException("Queue is full");
        if (count == 0) {
            arr[count] = data;
            count++;
        } else {
            for (int i = count; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = data;
            count++;
        }
    }

    public void remove() {
        if (count == 0) throw new RuntimeException("Queue is empty");
        arr[count - 1] = 0;
        count--;
    }

    public int peek() {
        if (count == 0) throw new RuntimeException("Queue is empty");
        int tmp = arr[count - 1];
        return tmp;
    }

    public boolean isEmpty() {
        boolean tmpBoolean = false;
        if (count == 0) {
            tmpBoolean = true;
        }
        return tmpBoolean;
    }

    public int size() {
        return count;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(3);

        myQueue.pushToEnd(1);
        myQueue.pushToEnd(2);
        myQueue.pushToEnd(3);
        myQueue.print();
        System.out.println();
        System.out.println(myQueue.size());

        myQueue.remove();
        myQueue.print();
        System.out.println(myQueue.peek());
        System.out.println(myQueue.size());
        myQueue.remove();
        myQueue.print();
        System.out.println(myQueue.peek());
        System.out.println(myQueue.size());
        myQueue.remove();
        myQueue.print();
        //System.out.println(myQueue.peek());
        System.out.println(myQueue.size());



    }
}




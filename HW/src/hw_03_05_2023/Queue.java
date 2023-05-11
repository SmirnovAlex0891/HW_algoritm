package hw_03_05_2023;

/**
 * Классическая Queue - реализовать используя массив (Array)
 */
class Queue<T> {
    private T[] arr;      // массив для хранения элементов queue
    private int head;      // head указывает на передний элемент в queue
    private int tail;       // tail часть указывает на последний элемент в queue
    private int capacity;   // максимальная емкость queue
    private int count;      // текущий размер queue

    // Конструктор для инициализации queue

    public Queue(int size) {
        arr = (T[]) new Object[size];
        capacity = size;
        count = 0;
        head = 0;
        tail = 0;
    }

    void pushToEnd(T data) {      // - вставляет элемент в конец queue
        if (count == capacity) {
            throw new IndexOutOfBoundsException();
        }
        arr[tail++] = data;
        count++;
    }

    T remove() {                 // - удаляет элемент из начала queue
        if (count == 0) {
            throw new NullPointerException();
        }
        T res = arr[head];
        System.arraycopy(arr, head + 1, arr, 0, count - 1);
        count--;
        tail--;
        return res;
    }

    T peek() {                      // - возвращает элемент из начала не удаляя его
        if (count == 0) {
            throw new NullPointerException();
        }
        return arr[head];
    }

    boolean isEmpty() {             // - boolean
        return count == 0;
    }

    int size() {                    // - int
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (i < count - 1) {
                sb.append(arr[i]).append(", ");
            } else {
                sb.append(arr[i]);
            }

        }
        return sb.toString();
    }
}

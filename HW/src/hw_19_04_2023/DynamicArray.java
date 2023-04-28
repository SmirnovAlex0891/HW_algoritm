package hw_19_04_2023;

import java.util.Arrays;
import java.util.Random;

class DynamicArray implements Dynamic{
    private int[] array;
    private int count;
    private int size;
    final private Random random = new Random();

    public DynamicArray() {
        this.array = new int[10];
        this.size = 10;
        this.count = -1;
    }
    public DynamicArray(int size) {
        this.size = size;
        array = new int[size];
        this.count = -1;
    }

    /**
     * void - добавляет элемент в конец
     */
    @Override
    public void add(int data) {
        if (count == size - 1) growSize();
        count++;
        array[count] = data;
    }

    /**
     * void - добавляет элемент по индексу, при этом, если это происходит в середине,
     * то все остальные элементы сдвигаются на 1 вправо
     */
    @Override
    public void addAt(int index, int data) {
        if (count == size - 1) growSize();
        if (index >= 0 && index <= count) {
            int[] arrayTmp = array.clone();
            arrayTmp[index] = data;
            System.arraycopy(array, index, arrayTmp, index + 1, count - (index - 1));
            array = arrayTmp;
            count++;
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    /**
     * void - удаляет первое вхождение элемента в массив, все остальные элементы справа,
     * сдвигаются на 1 влево
     */
    @Override
    public void remove(int data) {
        if (contains(data)) {
            int point = -1;
            for (int i = 0; i <= count; i++) {
                if (array[i] == data) {
                    point = i;
                    break;
                }
            }
            System.arraycopy(array, point + 1, array, point, count - point);
            array[count] = 0;
            count--;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * void - удаляет элемент по индексу, все остальные элементы справа, сдвигаются на 1 влево
     */
    @Override
    public void removeAt(int index) {
        if (index >= 0 && index <= count) {
            System.arraycopy(array, index + 1, array, index, count - index);
            array[count] = 0;
            count--;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * void - удваивает размер массива (capacity)
     */
    private void growSize() {
        int newSize = (int) ((size * 1.5) + 1);
        int[] growArray = new int[newSize];
        System.arraycopy(array, 0, growArray, 0, size);
        size = newSize;
        array = growArray;
    }

    /**
     * void - уменьшает размер массива до количества элементов (capacity = size)
     */
    @Override
    public void shrinkSize() {
        int[] shrinkArray = new int[count + 1];
        System.arraycopy(array, 0, shrinkArray, 0, count + 1);
        array = shrinkArray;
        size = count + 1;
    }

    /**
     * void - заменяет значения элемента по указанному индексу
     */
    @Override
    public void set(int index, int data) {
        if (index >= 0 && index <= count) {
            array[index] = data;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * int - возвращает элемент по указанному индексу (должна быть обработка,
     * если capacity позволяет добраться до этого элемента, а size - нет)
     */
    @Override
    public int get(int index) {
        if (index >= 0 && index <= count) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * void - удаляет все элементы из массива возвращая массив исходной длины (длина по умолчанию)
     */
    @Override
    public void clear() {
        array = new int[10];
        count = -1;
    }

    /**
     * boolean - возвращает true/false - если элемент есть в массиве
     */
    @Override
    public boolean contains(int data) {
        for (Integer x : array) {
            if (x == data) return true;
        }
        return false;
    }

    /**
     * boolean - возвращает true/false - если в массиве есть что-то.
     */
    @Override
    public boolean isEmpty() {
        return count == -1;
    }

    @Override
    public int size() {
        return count + 1;
    }


    @Override
    public String toString() {
        int[] res = new int[count + 1];
        System.arraycopy(array, 0, res, 0, count + 1);
        return Arrays.toString(res);
    }

    /**
     * методы removeXXX() - удаляют все элементы по 1 начиная с последнего/первого/середины соответственно.
     * Возвращают время в нс потраченное на удаление. Реализация должна быть такова, что при удалении элемента из
     * начала/середины все остальные элементы справа, сдвигаются на 1 влево в каждой итерации.
     */
    long removeLast() {
        int i = count;
        long start = System.nanoTime();
        while (i > -1) {
            array[i] = 0;
            i--;
        }
        return System.nanoTime() - start;
    }
    long removeFirst() {
        long start = System.nanoTime();
        while (count > -1) {
            System.arraycopy(array, 1, array, 0, count);
            array[count] = 0;
            count--;
        }
        return System.nanoTime() - start;
    }
    long removeMid() {
        long start = System.nanoTime();
        while (count >= 0) {
            int index = count / 2;
            System.arraycopy(array, index + 1, array, index, count - index);
            array[count] = 0;
            count--;
        }
        return System.nanoTime() - start;
    }
    /**
     * Методы fillXXX(int count) - создают новый массив такой же длинны (size) и заполняют его
     * рандомными элементами (class Random). Реализация должна быть такова, что при добавлении элемента в
     * начало/середину все остальные элементы справа, сдвигаются на 1 влево в каждой итерации.
     * Возвращают время в нс потраченное на создание.
     */
    long fillFromLast(int countMet) {
        array = new int[countMet];
        count = -1;
        long start = System.nanoTime();
        for (int i = 0; i < countMet; i++) {
            array[i] = random.nextInt(0, 100);
            count++;
        }
        return System.nanoTime() - start;
    }
    long fillFromFirst(int countMet) {
        array = new int[countMet];
        count = -1;
        long start = System.nanoTime();
        for (int i = 0; i < countMet; i++) {
            if (count == -1) {
                array[i] = random.nextInt(0, 100);
            }else {
                System.arraycopy(array, 0, array, 1, count + 1);
                array[0] = random.nextInt(0, 100);
            }
            count++;
        }
        return System.nanoTime() - start;
    }
    long fillFromMid(int countMet) {
        array = new int[countMet];
        count = -1;
        int index;
        long start = System.nanoTime();
        for (int i = 0; i < countMet; i++) {
            index = count / 2;
            if (index > 0) {
                System.arraycopy(array, index, array, index + 1, count - index + 1);
                array[index] = random.nextInt(0, 100);
            }else {
                array[count + 1] = random.nextInt(0, 100);
            }
            count++;
        }
        return System.nanoTime() - start;
    }
}

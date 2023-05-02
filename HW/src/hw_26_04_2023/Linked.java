package hw_26_04_2023;

interface Linked {
    void add( int data);
    void addAt(int index, int data);
    void remove(int data);
    void removeAt(int index);
    void set(int index, int data);
    int get(int index);
    void clear();
    boolean contains(int data);
    boolean isEmpty();
    int size();
}

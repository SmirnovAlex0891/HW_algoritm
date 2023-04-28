package hw_19_04_2023;

interface Dynamic {
    void add(int data);
    void addAt(int index, int data);
    void remove(int data);
    void removeAt(int index);
    void shrinkSize();
    void set(int index, int data);
    int get(int index);
    void clear();
    boolean contains(int data);
    boolean isEmpty();
    int size();
}

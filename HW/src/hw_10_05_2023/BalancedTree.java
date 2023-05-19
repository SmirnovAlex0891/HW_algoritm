package hw_10_05_2023;

interface BalancedTree {
    void add(int data);
    boolean search(int data);
    void remove(int data);
    int getDepth();
    int getSize();
    void traversalWidth();
    void traversalDepth();
}

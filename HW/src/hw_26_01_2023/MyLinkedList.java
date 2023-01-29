package hw_26_01_2023;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private Node<T> tNode;

    public MyLinkedList() {
        this.head = null;
    }
    public void pushToHead(T data) {
        Node<T> node = new Node<>(data, null, null);
        if (head == null) {
            head = node;
            tail = node;
            tNode = node;
        }else {
            node.setNext(head);
            tNode = node.getNext();
            tNode.setPrev(node);
            head = node;
        }
    }
    public void pushToTail(T data) {
        Node<T> node = new Node<>(data, null, null);
        if (head == null) {
            head = node;
            tail = node;
            tNode = node;
        }else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
    }
    public T removeHead() {
        if (head == null) throw new RuntimeException("List is empty");
        T data = null;
        if (head != null && head.getNext() != null) {
            data = head.getData();
            head = head.getNext();
            head.setPrev(null);
        }else {
            data = head.getData();
            head = null;
            tail = null;
        }
        return data;
    }
    public T removeTail() {
        T data = null;
        if (tail == null) throw new RuntimeException("List is empty");
        if (tail != null && tail.getPrev() != null) {
            data = tail.getData();
            tNode = tail.getPrev();
            tNode.setNext(null);
            tail = tNode;
        }else {
            data = tail.getData();
            head = null;
            tail = null;
        }
        return data;
    }
    public Node<T> getLast() {
        return tail;
    }
    public T get(int index) {
        if (head == null) throw new RuntimeException("List is empty");
        int tmp = 0;
        Node<T> node = head;
        while (node != null && node.getNext() != null && tmp != index) {
            tmp++;
            node = node.getNext();
        }
        if (index > tmp) throw new RuntimeException("Index outside");
        if (tmp == index) return node.getData();
        else return null;
    }
    public boolean pushToIndex(int index, T data) {
        if (head == null && index > 0) throw new RuntimeException("List is empty");
        Node<T> nodeNew = new Node<>(data, null, null);
        if (index == 0 && head == null) {
            head = nodeNew;
            tail = nodeNew;
            return true;
        }
        int tmp = 0;
        Node<T> node = head;
        if (index == 0) {
            nodeNew.setNext(node);
            node.setPrev(nodeNew);
            head = nodeNew;
            return true;
        }
        while (node != null && node.getNext() != null && tmp != index-1) {
            tmp++;
            node = node.getNext();
        }
        if (tmp == index-1) {
            tNode = node.getNext();
            node.setNext(nodeNew);
            nodeNew.setPrev(node);
            node = tNode;
            nodeNew.setNext(node);
            node.setPrev(nodeNew);
            return true;
        }
        return false;
    }
    public void remove(int index) {
        int tmp = 0;
        Node<T> node = head;
        if (index == 0) {
            node = node.getNext();
            node.setPrev(null);
            head = node;
        }else {
            while (node != null && node.getNext() != null && tmp != index) {
                tmp++;
                node = node.getNext();
            }
            if (index > tmp) throw new RuntimeException("Index outside");
            if (node == tail) {
                node = node.getPrev();
                node.setNext(null);
                tail = node;
            }else {
                tNode = node.getPrev();
                tNode.setNext(node.getNext());
                tNode = node.getNext();
                tNode.setPrev(node.getPrev());
            }
        }
    }
    public int size() {
        int tmp = 1;
        Node<T> node = head;
        if (node == null) return 0;
        while (node != null && node.getNext() != null) {
            node = node.getNext();
            tmp++;
        }
        return tmp;
    }
    public void reverse() {
        Node<T> nodeP = null;
        Node<T> nodeF = head;
        Node<T> node = head;
        tail = node;
        while (nodeF != null) {
            node = nodeF;
            nodeF = node.getNext();

            node.setNext(nodeP);
            node.setPrev(nodeF);
            nodeP = node;
        }
        head = node;
    }
    public void print() {
        Node<T> node = head;
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
    public void printRev() {
        Node<T> node = tail;
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getPrev();
        }
        System.out.println();
    }
}

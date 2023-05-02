package hw_26_04_2023;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedList implements Linked {
    private Node last;
    private Node first;
    private int size;
    private Node tNode;

    public MyLinkedList() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    /**
     * void - добавляет элемент в конец списка
     */
    @Override
    public void add(int data) {
        tNode = new Node(data);
        if (size == 0) {
            first = tNode;
            last = tNode;
            size++;
        } else {
            tNode.setPrev(last);
            last.setNext(tNode);
            last = tNode;
            size++;
        }
    }

    /**
     * void - добавляет элемент по индексу
     */
    @Override
    public void addAt(int index, int data) {
        if (index <= size) {
            tNode = new Node(data);
            Node node1;
            Node node2;
            if (index == 0) {
                tNode.setNext(first);
                first.setPrev(tNode);
                first = tNode;
                size++;
            } else if (index == size) {
                tNode.setPrev(last);
                last.setNext(tNode);
                last = tNode;
                size++;
            } else {
                if (index <= size - 1 - index) {
                    node1 = first;
                    node2 = node1.getNext();
                    for (int i = 1; i < index; i++) {
                        node1 = node2;
                        node2 = node1.getNext();
                    }
                } else {
                    node2 = last;
                    node1 = node2.getPrev();
                    for (int i = size - 1; i > index; i--) {
                        node2 = node1;
                        node1 = node2.getPrev();
                    }
                }
                node1.setNext(tNode);
                tNode.setPrev(node1);
                tNode.setNext(node2);
                node2.setPrev(tNode);
                size++;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    /**
     * void - удаляет первое вхождение элемента в список
     */
    @Override
    public void remove(int data) {
        tNode = first;
        for (int i = 0; i < size; i++) {
            if (tNode.getData() == data) {
                if (tNode == first) {
                    first = first.getNext();
                    first.setPrev(null);
                    size--;
                } else if (tNode == last) {
                    last = last.getPrev();
                    last.setNext(null);
                    size--;
                } else {
                    Node node1 = tNode.getPrev();
                    Node node2 = tNode.getNext();
                    node1.setNext(node2);
                    node2.setPrev(node1);
                    size--;
                    break;
                }
            }
            tNode = tNode.getNext();
        }
    }

    /**
     * void - удаляет элемент по индексу
     */
    @Override
    public void removeAt(int index) {
        if (index < size) {
            if (index == 0) {
                first = first.getNext();
                first.setPrev(null);
                size--;
            } else if (index == size - 1) {
                last = last.getPrev();
                last.setNext(null);
                size--;
            } else {
                if (index <= size - 1 - index) {
                    tNode = first;
                    for (int i = 0; i < index; i++) {
                        tNode = tNode.getNext();
                    }
                } else {
                    tNode = last;
                    for (int i = size - 1; i > index; i--) {
                        tNode = tNode.getPrev();
                    }
                }
                Node node1 = tNode.getPrev();
                Node node2 = tNode.getNext();
                node1.setNext(node2);
                node2.setPrev(node1);
                size--;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * void - заменяет значения элемента по указанному индексу
     */
    @Override
    public void set(int index, int data) {
        if (index < size) {
            if (index <= size - 1 - index) {
                tNode = first;
                for (int i = 0; i < index; i++) {
                    tNode = tNode.getNext();
                }
            } else {
                tNode = last;
                for (int i = size - 1; i > index; i--) {
                    tNode = tNode.getPrev();
                }
            }
            tNode.setData(data);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * int - возвращает элемент по указанному индексу
     */
    @Override
    public int get(int index) {
        if (index < size) {
            if (index <= size - 1 - index) {
                tNode = first;
                for (int i = 0; i < index; i++) {
                    tNode = tNode.getNext();
                }
            } else {
                tNode = last;
                for (int i = size - 1; i > index; i--) {
                    tNode = tNode.getPrev();
                }
            }
            return tNode.getData();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * void - удаляет все элементы, оставляет пустой список
     */
    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * boolean - возвращает true/false - если элемент есть в списке
     */
    @Override
    public boolean contains(int data) {
        tNode = first;
        while (tNode != null) {
            if (tNode.getData() == data) return true;
            tNode = tNode.getNext();
        }
        return false;
    }

    /**
     * boolean - возвращает true/false - если в списке есть что-то.
     */
    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    /**
     * int  - возвращает количество элементов в списке
     */
    @Override
    public int size() {
        return size;
    }

    void printMyLinkList() {
        List<Integer> tmp = new ArrayList<>();
        tNode = first;
        while (tNode != null) {
            tmp.add(tNode.getData());
            tNode = tNode.getNext();
        }
        System.out.println(tmp);
    }

    private class Node {
        public Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }

        Node next;
        Node prev;
        int data;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}

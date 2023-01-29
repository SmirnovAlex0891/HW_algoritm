package hw_26_01_2023;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.pushToHead(11);
        list.pushToHead(21);
        list.pushToHead(31);
        list.pushToHead(41);
        list.pushToHead(51);
        list.pushToHead(61);

//        list.print();
//        System.out.println(list.get(5));
//        list.pushToIndex(3, 99);
//        list.print();
//        System.out.println(list.pushToIndex(7, 88));
//        list.print();
//        System.out.println(list.size());
        list.print();
        list.reverse();
        list.pushToIndex(2, 10);
        list.print();



//        list.pushToHead(50);
//        list.removeHead();
//        list.print();
//        list.removeHead();
//        list.print();
//        list.removeHead();
//        list.print();
//        list.removeHead();
//        list.print();
//        list.removeHead();
//        list.print();
//        list.removeHead();
//        list.print();
//        list.removeHead();
//        list.print();
    }
}

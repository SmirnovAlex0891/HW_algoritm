package hw_26_04_2023;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(11);
        myLinkedList.add(12);
        myLinkedList.add(13);
        myLinkedList.add(14);
        myLinkedList.add(15);

        myLinkedList.printMyLinkList();
        myLinkedList.addAt(2, 100);
        myLinkedList.printMyLinkList();
        myLinkedList.remove(14);
        myLinkedList.printMyLinkList();
        myLinkedList.removeAt(2);
        myLinkedList.printMyLinkList();
        System.out.println(myLinkedList.size());
    }
}

package hw_19_04_2023;

public class DynamicArrayTest {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();

        System.out.println("add last element: " + dynamicArray.fillFromLast(100_000));
        System.out.println("Size dynamicArray: " + dynamicArray.size());
        System.out.println("remove last element: " + dynamicArray.removeLast());
        System.out.println("**********************************************************");
        System.out.println("add first element: " + dynamicArray.fillFromFirst(100_000));
        System.out.println("Size dynamicArray: " + dynamicArray.size());
        System.out.println("remove first element: " + dynamicArray.removeFirst());
        System.out.println("**********************************************************");
        System.out.println("add mid element: " + dynamicArray.fillFromMid(100_000));
        System.out.println("Size dynamicArray: " + dynamicArray.size());
        System.out.println("remove mid element: " + dynamicArray.removeMid());



    }

}

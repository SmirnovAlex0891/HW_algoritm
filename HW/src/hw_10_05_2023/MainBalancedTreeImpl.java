package hw_10_05_2023;

public class MainBalancedTreeImpl {
    public static void main(String[] args) {
        BalancedTreeImpl tree = new BalancedTreeImpl();
        tree.add(5);
        tree.add(10);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.add(15);
        tree.add(12);
        tree.add(20);

        //tree.remove(10);


        System.out.println(tree.getSize());

        System.out.println("********************************************");
        //tree.traversalDepth();
        tree.printTree();
    }
}

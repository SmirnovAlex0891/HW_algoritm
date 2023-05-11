package hw_03_05_2023;

public class TestMyQueue {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>(10);
        queue.pushToEnd("aaa");
        queue.pushToEnd("bbb");
        queue.pushToEnd("ccc");
        queue.pushToEnd("ddd");

        System.out.println(queue);
        System.out.println(queue.size());

        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
//        System.out.println(queue.remove());
//        System.out.println(queue);
        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        queue.pushToEnd("fff");
        queue.pushToEnd("eee");
        queue.pushToEnd("qqq");
        queue.pushToEnd("ttt");
        queue.pushToEnd("www");
        queue.pushToEnd("yyy");
        queue.pushToEnd("uuu");
        queue.pushToEnd("ppp");
        queue.pushToEnd("lll");
        System.out.println(queue.size());
        System.out.println(queue);


    }
}

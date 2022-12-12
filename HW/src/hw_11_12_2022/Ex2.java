package hw_11_12_2022;

import java.util.Stack;

public class Ex2 {
    public static void main(String[] args) {
        Stack<Integer> firstPole = new Stack<>();
        Stack<Integer> secondPole = new Stack<>();
        Stack<Integer> thirdPole = new Stack<>();

        firstPole.add(3);
        firstPole.add(2);
        firstPole.add(1);
        System.out.println(firstPole);
        moveRing(firstPole, secondPole, thirdPole, 3);
        System.out.println(secondPole);
        System.out.println(thirdPole);
    }
    static void moveRing(Stack<Integer> firstPole, Stack<Integer> secondPole, Stack<Integer> thirdPole, int numOfRings) {
        if(numOfRings<=0) return;
        moveRing(firstPole,thirdPole,secondPole,numOfRings-1);
        thirdPole.push(firstPole.pop());
        moveRing(secondPole,firstPole,thirdPole,numOfRings-1);
    }

}

package hw_15_03_2023;

import java.util.Stack;

/**
 * Задача заключается в следующем. Имеется три стержня — левый, средний и правый. На левом стержне находятся n дисков,
 * диаметры которых различны. Диски упорядочены по размеру диаметра, сверху лежит наименьший, снизу — наибольший.
 * Требуется перенести диски с левого стержня на правый, используя средний стержень как вспомогательный.
 * <p>
 * Головоломка имеет следующие два правила:
 * 1. Вы не можете поместить больший диск на меньший диск.
 * 2. За один раз можно перемещать только один диск.
 * <p>
 * <p>
 * Реализуйте два подхода для решения.
 * <p>
 * <p>
 * Итеративно
 * Рекурсивно
 */
public class hw1 {
    public static void main(String[] args) {
        Stack<Integer> firstPole = new Stack<>();
        Stack<Integer> secondPole = new Stack<>();
        Stack<Integer> thirdPole = new Stack<>();

        firstPole.add(88);
        firstPole.add(77);
        firstPole.add(66);
        firstPole.add(55);
        firstPole.add(44);
        firstPole.add(33);
        firstPole.add(22);
        firstPole.add(11);
        System.out.println(firstPole);
        moveRingIter(firstPole, secondPole, thirdPole, 8);
        System.out.println(thirdPole);
    }

    public static void moveRingRec(Stack<Integer> first, Stack<Integer> second, Stack<Integer> third, int numberOfRing) {
        if (numberOfRing <= 0) return;
        moveRingRec(first, third, second, numberOfRing - 1);
        third.push(first.pop());
        moveRingRec(second, first, third, numberOfRing - 1);
    }

    public static void moveRingIter(Stack<Integer> first, Stack<Integer> second, Stack<Integer> third, int numberOfRing) {
        while (third.size() < numberOfRing) {
            if (first.size() > 0 && third.size() > 0) {
                if (first.peek() < third.peek()) {
                    third.push(first.pop());
                } else {
                    first.push(third.pop());
                }
            } else {
                if (first.size() > 0) {
                    third.push(first.pop());
                } else if (third.size() > 0) {
                    first.push(third.pop());
                }
            }
            if (first.size() > 0 && second.size() > 0) {
                if (first.peek() < second.peek()) {
                    second.push(first.pop());
                } else {
                    first.push(second.pop());
                }
            } else {
                if (first.size() > 0) {
                    second.push(first.pop());
                } else if (second.size() > 0) {
                    first.push(second.pop());
                }
            }
            if (third.size() > 0 && second.size() > 0) {
                if (third.peek() < second.peek()) {
                    second.push(third.pop());
                } else {
                    third.push(second.pop());
                }
            } else {
                if (third.size() > 0 && third.size() != numberOfRing) {
                    second.push(third.pop());
                } else if (third.size() == 0 && second.size() > 0) {
                    third.push(second.pop());
                }
            }
        }
    }
}

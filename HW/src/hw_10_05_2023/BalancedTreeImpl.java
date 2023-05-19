package hw_10_05_2023;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BalancedTreeImpl implements BalancedTree {
    private TreeNode node;      // - корневой элемент
    private TreeNode tNode;
    private int size;           // - количество нод

    public BalancedTreeImpl() {
        node = null;
        size = 0;
    }

    @Override
    public void add(int data) {                 // void - добавить элемент в дерево
        TreeNode newNode = new TreeNode(data, null, null);
        if (node == null) {
            node = newNode;
            size++;
        } else {
            tNode = node;
            while (true) {
                if (tNode.getData() == newNode.getData()) break;
                if (tNode.getData() > newNode.getData()) {
                    if (tNode.leftNode == null) {
                        tNode.setLeftNode(newNode);
                        break;
                    } else {
                        tNode = tNode.leftNode;
                    }
                } else {
                    if (tNode.rightNode == null) {
                        tNode.setRightNode(newNode);
                        break;
                    } else {
                        tNode = tNode.rightNode;
                    }
                }
            }
            size++;
        }
    }

    @Override
    public boolean search(int data) {           // boolean - true/false если указанный элемент есть или его нет
        tNode = node;
        if (tNode != null) {
            while (true) {
                if (tNode.getData() == data) return true;
                if (tNode.getData() > data) {
                    if (tNode.leftNode == null) break;
                    tNode = tNode.leftNode;
                } else {
                    if (tNode.rightNode == null) break;
                    tNode = tNode.rightNode;
                }
            }
        }
        return false;
    }

    @Override
    public void remove(int data) {              // void - удаляет элемент из дерева
        TreeNode parentNode = node;
        TreeNode removableNode = node;
        boolean isLeftNode = true;
        TreeNode lNode;
        TreeNode rNode;

        while (true) {
            if (removableNode == null) {
                return;
            } else if (removableNode.getData() == data) {
                break;
            } else if (removableNode.getData() > data) {
                parentNode = removableNode;
                removableNode = parentNode.leftNode;
                isLeftNode = true;
            } else {
                parentNode = removableNode;
                removableNode = parentNode.rightNode;
                isLeftNode = false;
            }
        }

        lNode = removableNode.leftNode;
        rNode = removableNode.rightNode;
        if (lNode == null && rNode == null) {
            if (removableNode == node) {
                node = null;
            } else if (isLeftNode) {
                parentNode.setLeftNode(null);
            } else {
                parentNode.setRightNode(null);
            }
        } else if (rNode == null) {
            if (removableNode == node) {
                node = removableNode.leftNode;
            } else if (isLeftNode) {
                parentNode.setLeftNode(removableNode.leftNode);
            } else {
                parentNode.setRightNode(removableNode.leftNode);
            }
        } else if (lNode == null) {
            if (removableNode == node) {
                node = removableNode.rightNode;
            } else if (isLeftNode) {
                parentNode.setLeftNode(removableNode.rightNode);
            } else {
                parentNode.setRightNode(removableNode.rightNode);
            }
        } else {
            tNode = searchForReplacement(removableNode);
            if (removableNode == node) {
                node = tNode;
            } else if (isLeftNode) {
                parentNode.setLeftNode(tNode);
            } else {
                parentNode.setRightNode(tNode);
            }
        }
        size--;
    }

    private TreeNode searchForReplacement(TreeNode startNode) {
        TreeNode parentNode = startNode;
        TreeNode heirNode = startNode;
        TreeNode currentNode = startNode.rightNode;

        while (currentNode != null) {
            parentNode = heirNode;
            heirNode = currentNode;
            currentNode = currentNode.leftNode;
        }
        if (heirNode != startNode.rightNode) {
            parentNode.setLeftNode(heirNode.rightNode);
            heirNode.setRightNode(startNode.rightNode);
        }
        heirNode.leftNode = startNode.leftNode;
        return heirNode;
    }

    @Override
    public int getDepth() {                     // int - возвращает самый длинный путь от корня до самого дальнего листа (количество нод)
        int depthFromRoot = -1;
        return getDepthNode(depthFromRoot, node);
    }

    private int getDepthNode(int depthFromStart, TreeNode startNode) {
        int left = 0;
        int right = 0;
        depthFromStart++;
        if (startNode.leftNode == null && startNode.rightNode == null) return depthFromStart;
        if (startNode.leftNode != null) {
            left = getDepthNode(depthFromStart, startNode.leftNode);
        }
        if (startNode.rightNode != null) {
            right = getDepthNode(depthFromStart, startNode.rightNode);
        }
        return Math.max(left, right);
    }

    @Override
    public int getSize() {                      // int - возвращает количество нод
        return size;
    }

    private int getSizeFromStart(TreeNode startNode, int numNode) {
        numNode++;
        if (startNode.leftNode == null && startNode.rightNode == null) return numNode;
        if (startNode.leftNode != null) {
            numNode = getSizeFromStart(startNode.leftNode, numNode);
        }
        if (startNode.rightNode != null) {
            numNode = getSizeFromStart(startNode.rightNode, numNode);
        }
        return numNode;
    }

    @Override
    public void traversalWidth() {              // void - обход дерева в ширину, печатает в консоль
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode nodeMeth = queue.remove();
            System.out.println(nodeMeth.getData());

            if (nodeMeth.leftNode != null) {
                queue.add(nodeMeth.leftNode);
            }

            if (nodeMeth.rightNode != null) {
                queue.add(nodeMeth.rightNode);
            }
        }
    }

    @Override
    public void traversalDepth() {              // void - обход дерева в глубину, печатает в консоль
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            TreeNode nodeMeth = stack.pop();
            System.out.println(nodeMeth.getData());

            if (nodeMeth.rightNode != null) {
                stack.push(nodeMeth.rightNode);
            }

            if (nodeMeth.leftNode != null) {
                stack.push(nodeMeth.leftNode);
            }
        }
    }

    private static class TreeNode {
        private final int data;
        private TreeNode leftNode;
        private TreeNode rightNode;

        public TreeNode(int data, TreeNode leftNode, TreeNode rightNode) {
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        public int getData() {
            return data;
        }

        public void setLeftNode(TreeNode leftNode) {
            this.leftNode = leftNode;
        }

        public void setRightNode(TreeNode rightNode) {
            this.rightNode = rightNode;
        }
    }

    public void printTree() { // метод для вывода дерева в консоль
        Stack<TreeNode> globalStack = new Stack<>(); // общий стек для значений дерева
        globalStack.push(node);
        int gaps = 32; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (!isRowEmpty) {
            Stack<TreeNode> localStack = new Stack<>(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (!globalStack.isEmpty()) { // покуда в общем стеке есть элементы
                TreeNode temp = globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.data); // выводим его значение в консоли
                    localStack.push(temp.leftNode); // сохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.rightNode);
                    if (temp.leftNode != null ||
                            temp.rightNode != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }
}

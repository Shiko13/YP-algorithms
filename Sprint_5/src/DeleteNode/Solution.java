package DeleteNode;

/*
ID отчёта: https://contest.yandex.ru/contest/24810/run-report/69577573/
По входящим данным строим указанное дерево и ищем нужный ключ, если он есть в дереве, мы
рассматриваем несколько случаев:
1. У узла нет потомков, тогда просто удаляем узел.
2. Если у узла один потомок, то ставим на его место потомок, а узел удаляем.
3. Если у узла два потомка, то ищем минимальный элемент по его правому потомку, ставим его на
место узла, а узел удаляем.
Временная сложность: O(h), где h — высота дерева.
Пространственная сложность: вроде бы она тоже О(h), поскольку нам, помимо самого дерева, нужно
хранить путь до удаляемого элемента/элемента, с которым произойдёт обмен.
*/

public class Solution {
    public static Node remove(Node root, int key) {
        Node parent = null;
        Node current = root;

        while (current != null && current.getValue() != key) {
            parent = current;

            if (key < current.getValue()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        if (current == null) {
            return root;
        }

        if (current.getLeft() == null && current.getRight() == null) {
            if (current != root) {
                if (parent.getLeft() == current) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            } else {
                return null;
            }
        } else if (current.getLeft() != null && current.getRight() != null) {
            Node successor = findMinimum(current.getRight());
            int val = successor.getValue();

            remove(root, successor.getValue());
            current.setValue(val);
        } else {
            Node child = (current.getLeft() != null) ? current.getLeft() : current.getRight();
            if (current != root) {
                if (current == parent.getLeft()) {
                    parent.setLeft(child);
                } else {
                    parent.setRight(child);
                }
            } else {
                root = child;
            }
        }
        return root;
    }

    public static Node findMinimum(Node current) {
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }


    public static class Node {
        private int value;
        private Node left;
        private Node right;

        Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


    private static void test() {
        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(node1, null, 3);
        Node node3 = new Node(null, node2, 1);
        Node node4 = new Node(null, null, 6);
        Node node5 = new Node(node4, null, 8);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node3, node6, 5);
        Node newHead = remove(node7, 10);
        assert newHead.getValue() == 5;
        assert newHead.getRight() == node5;
        assert newHead.getRight().getValue() == 8;
    }
}

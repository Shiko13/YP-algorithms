package BalancedTree;

public class Solution {
    public static boolean treeSolution(Node head) {
        if (head == null) {
            return true;
        }

        int leftHeight = findHeight(head.left);
        int rightHeight = findHeight(head.right);
        if (Math.abs(leftHeight - rightHeight) <= 1 && treeSolution(head.left)
                && treeSolution(head.right)) {
            return true;
        } else {
            return false;
        }
    }

    static Integer findHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return Integer.max(findHeight(node.left), findHeight(node.right)) + 1;
    }

        private static class Node {
            int value;
            Node left;
            Node right;

            Node(int value) {
                this.value = value;
                this.left = null;
                this.right = null;
            }
        }

    private static void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(-5);
        Node node3 = new Node(3);
        node3.left = node1;
        node3.right = node2;
        Node node4 = new Node(10);
        Node node5 = new Node(2);
        node5.left = node3;
        node5.right = node4;
        assert treeSolution(node5);
    }
}


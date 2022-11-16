package TwinTrees;

public class Solution {
    public static boolean treeSolution(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.value == node2.value && treeSolution(node1.left, node2.left) &&
                treeSolution(node1.right, node2.right);
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

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private static void test() {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(2, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(1, null, null);
        Node node5 = new Node(2, null, null);
        Node node6 = new Node(3, node4, node5);
        assert treeSolution(node3, node6);
    }
}

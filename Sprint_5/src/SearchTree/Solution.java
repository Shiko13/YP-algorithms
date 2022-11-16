package SearchTree;


public class Solution {
    public static boolean treeSolution(Node node) {
        return (boolean) isBST(node)[0];
    }

    static Object[] isBST(Node node) {
        if (node == null) {
            return new Object[]{true, null, null};
        }

        Integer minLeft = null;
        Integer maxLeft = null;
        Integer minRight = null;
        Integer maxRight = null;

        Object[] leftBST = isBST(node.left);
        boolean isLeftBST = (boolean) leftBST[0];
        if (leftBST[1] != null) {
            minLeft = (Integer) leftBST[1];
        }
        if (leftBST[2] != null) {
            maxLeft = (Integer) leftBST[2];
        }

        Object[] rightBST = isBST(node.right);
        boolean isRightBST = (boolean) rightBST[0];
        if (rightBST[1] != null) {
            minRight = (Integer) rightBST[1];
        }
        if (rightBST[2] != null) {
            maxRight = (Integer) rightBST[2];
        }

        boolean isBSTNode = isLeftBST && isRightBST && (maxLeft == null || node.value > maxLeft) &&
                (minRight == null || node.value < minRight);
        Integer minValue = min(minLeft, minRight, node.value);
        Integer maxValue = max(minRight, maxRight, node.value);
        return new Object[]{isBSTNode, minValue, maxValue};
    }

    public static Integer min(Integer a, Integer b, Integer c) {
        if (a == null && b == null && c == null) {
            return null;
        } else if (a == null && b == null && c != null) {
            return c;
        } else if (a == null && b != null && c == null) {
            return b;
        } else if (a != null && b == null && c == null) {
            return a;
        } else if (a == null) {
            return Math.min(b, c);
        } else if (b == null) {
            return Math.min(a, c);
        } else if (c == null) {
            return Math.min(a, b);
        } else {
            return Math.min(Math.min(a, b), c);
        }
    }

    public static Integer max(Integer a, Integer b, Integer c) {
        if (a == null && b == null && c == null) {
            return null;
        } else if (a == null && b == null && c != null) {
            return c;
        } else if (a == null && b != null && c == null) {
            return b;
        } else if (a != null && b == null && c == null) {
            return a;
        } else if (a == null) {
            return Math.max(b, c);
        } else if (b == null) {
            return Math.max(a, c);
        } else if (c == null) {
            return Math.max(a, b);
        } else {
            return Math.max(Math.max(a, b), c);
        }
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
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(8, null, null);
        Node node5 = new Node(5, node3, node4);
        assert treeSolution(node5);
        node2.value = 5;
        assert !treeSolution(node5);
    }
}

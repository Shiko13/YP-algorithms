package CaringMother;

//Compiler Make
class Node<V> {
    public V value;
    public Node<V> next;

    public Node(V value, Node<V> next) {
        this.value = value;
        this.next = next;
    }
}


public class Solution {
    public static int solution(Node<String> head, String elem) {
        int idx = 0;
        while (head.next != null) {
            if (head.value.equals(elem)) {
                return idx;
            } else {
                idx++;
            }
            head = head.next;
        }
        return -1;
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        int idx = solution(node0, "node2");
        // result is : idx == 2
    }
}


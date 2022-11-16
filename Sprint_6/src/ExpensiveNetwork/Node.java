package ExpensiveNetwork;

class Node implements Comparable<Node> {
    Integer vertex;
    Integer edge;

    public Node(Integer vertex, Integer edge) {
        this.vertex = vertex;
        this.edge = edge;
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(node.edge, this.edge);
    }
}

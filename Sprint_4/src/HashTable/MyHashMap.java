package HashTable;

import java.util.ArrayList;

class MyHashMap {
    final ArrayList<Node> nodeList;

    public MyHashMap(int volume) {
        nodeList = new ArrayList<>();
        //У List, я так понял, нет метода ensureCapacity, потому оставил ArrayList в поле
        nodeList.ensureCapacity(volume);
        for (int i = 0; i < volume; i++) {
            nodeList.add(null);
        }
    }

    public Integer put(Integer key, Integer value) {
        Node node = getNodeKey(key);
        if (node != null) {
            node.setValue(value);
            return value;
        }

        node = new Node(key, value);
        int numberOfBucket = calculateNumberOfBucket(key);
        if (nodeList.get(numberOfBucket) != null) {
            node.setNext(nodeList.get(numberOfBucket));
            node.getNext().setPrev(node);
        }
        nodeList.set(numberOfBucket, node);
        return null;
    }

    public Integer getKey(Integer key) {
        if (key == null) {
            return null;
        }
        Node node = getNodeKey(key);
        return node == null ? null : node.getValue();
    }

    public Integer deleteKey(Integer key) {
        Node node = getNodeKey(key);
        if (node == null) {
            return null;
        }

        if (node.getPrev() != null) {
            node.getPrev().setNext(node.getNext());
        } else {
            int hashKey = calculateNumberOfBucket(key);
            nodeList.set(hashKey, node.getNext());
        }

        if (node.getNext() != null) {
            node.getNext().setPrev(node.getPrev());
        }
        return node.getValue();
    }

    public Node getNodeKey(Integer key) {
        int numberOfBucket = calculateNumberOfBucket(key);
        Node node = nodeList.get(numberOfBucket);
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    public int calculateNumberOfBucket(Integer key) {
        return (int) key % nodeList.size();
    }
}

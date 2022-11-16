package Deque;

class Deque {

    final int[] stack;
    final int maxN;
    private int size;
    private int head;
    private int tail;
    public Deque (int maxN) {
        this.maxN = maxN;
        this.stack = new int[maxN];
        size = 0;
        head = 0;
        tail = 0;
    }

    public void pushBack(int value) {
        if (size != maxN) {
            if (tail >= 0) {
                stack[tail] = value;
            } else {
                stack[maxN + tail] = value;
            }
            tail = (tail + 1) % maxN;
            size++;
        } else {
            System.out.println("error");
        }
    }

    public void pushFront(int value) {
        if (size != maxN) {
            if (head > 0) {
                stack[head - 1] = value;
            } else {
                stack[maxN - 1 + head] = value;
            }
            head = (head - 1) % maxN;
            size++;
        } else {
            System.out.println("error");
        }
    }

    public void popFront() {
        int x = 0;
        if (isEmpty()) {
            System.out.println("error");
        } else {
            if (head >= 0) {
                x = stack[head];
            } else {
                x = stack[maxN + head];
            }
            System.out.println(x);
            if (head >= 0) {
                stack[head] = 0;
            } else {
                stack[maxN + head] = 0;
            }
            head = (head + 1) % maxN;
            size--;
        }
    }

    public void popBack() {
        int x = 0;
        if (isEmpty()) {
            System.out.println("error");
        } else {
            if (tail > 0) {
                x = stack[tail - 1];
            } else {
                x = stack[maxN - 1 + tail];
            }
            System.out.println(x);
            if (tail > 0) {
                stack[tail - 1] = 0;
            } else {
                stack[maxN - 1 + tail] = 0;
            }
            tail = (tail - 1) % maxN;
            size--;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
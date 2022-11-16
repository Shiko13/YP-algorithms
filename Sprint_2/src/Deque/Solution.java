package Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int amountOfCommand = Integer.parseInt(reader.readLine());
        int maxN = Integer.parseInt(reader.readLine());
        Deque deque = new Deque(maxN);
        for (int i = 0; i < amountOfCommand; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            switch (tokenizer.nextToken()) {
                case "push_back" -> {
                    int x = Integer.parseInt(tokenizer.nextToken());
                    deque.pushBack(x);
                }
                case "push_front" -> {
                    int y = Integer.parseInt(tokenizer.nextToken());
                    deque.pushFront(y);
                }
                case "pop_back" -> deque.popBack();
                case "pop_front" -> deque.popFront();
            }
        }
        reader.close();
    }
}

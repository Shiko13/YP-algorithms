package StackMax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StackMax {
    ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StackMax stackMax = new StackMax();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int amountOfCommand = Integer.parseInt(reader.readLine());

        for (int i = 0; i < amountOfCommand; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            switch (tokenizer.nextToken()) {
                case "push" -> {
                    int a = Integer.parseInt(tokenizer.nextToken());
                    stackMax.push(a);
                }
                case "pop" -> stackMax.pop();
                case "get_max" -> stackMax.getMax();
            }
        }
    }

    public void push(int value) {
        list.add(value);
    }

    public void pop() {
        if (list.isEmpty()) {
            System.out.println("error");
        } else {
            list.remove(list.size() - 1);
        }
    }

    public void getMax() {
        if (list.isEmpty()) {
            System.out.println("None");
        } else {
            int max = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) > max) {
                    max = list.get(i);
                }
            }
            System.out.println(max);
        }
    }
}

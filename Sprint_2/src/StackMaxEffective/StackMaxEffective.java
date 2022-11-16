package StackMaxEffective;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StackMaxEffective {
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> max = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StackMaxEffective stackMaxEffective = new StackMaxEffective();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int amountOfCommand = Integer.parseInt(reader.readLine());

        for (int i = 0; i < amountOfCommand; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            switch (tokenizer.nextToken()) {
                case "push" -> {
                    int a = Integer.parseInt(tokenizer.nextToken());
                    stackMaxEffective.push(a);
                }
                case "pop" -> stackMaxEffective.pop();
                case "get_max" -> stackMaxEffective.getMax();
            }
        }
    }

    public void push(int value) {
        if (list.size() == 0) {
            max.add(value);
        } else if (value > max.get(max.size() - 1)) {
            max.add(value);
        } else {
            max.add(max.get(max.size() - 1));
        }
        list.add(value);
    }

    public void pop() {
        if (list.isEmpty()) {
            System.out.println("error");
        } else {
            max.remove(max.size() - 1);
            list.remove(list.size() - 1);
        }
    }

    public void getMax() {
        if (list.isEmpty()) {
            System.out.println("None");
        } else {
            System.out.println(max.get(max.size() - 1));
        }
    }
}

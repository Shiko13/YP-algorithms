package LimitedQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    static int amountOfCommand;
    static int stackSize;
    int count = 0;


    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        amountOfCommand = Integer.parseInt(reader.readLine());
        stackSize = Integer.parseInt(reader.readLine());

        for (int i = 0; i < amountOfCommand; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            switch (tokenizer.nextToken()) {
                case "push" -> {
                    int a = Integer.parseInt(tokenizer.nextToken());
                    solution.push(a);
                }
                case "pop" -> solution.pop();
                case "size" -> System.out.println(solution.size());
                case "peek" -> solution.peek();
            }
        }
        reader.close();
    }

    public void push(int value) {
        if (count < stackSize) {
            list.add(value);
            count++;
        } else {
            System.out.println("error");
        }
    }

    public void pop() {
        if (count == 0) {
            System.out.println("None");
        } else {
            System.out.println(list.get(0));
            list.remove(0);
            count--;
        }
    }

    public void peek() {
        if (count == 0) {
            System.out.println("None");
        } else {
            System.out.println(list.get(0));
        }
    }

    public int size() {
        return count;
    }
}

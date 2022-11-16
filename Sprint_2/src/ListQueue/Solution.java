package ListQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    LinkedList list = new LinkedList();

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int amountOfCommand = Integer.parseInt(reader.readLine());

        for (int i = 0; i < amountOfCommand; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            switch (tokenizer.nextToken()) {
                case "put" -> {
                    int a = Integer.parseInt(tokenizer.nextToken());
                    s.put(a);
                }
                case "get" -> s.get();
                case "size" -> System.out.println(s.size());
            }
        }
        reader.close();
    }

    public void put(int value) {
        list.add(0, value);
    }

    public void get() {
        if (list.size() == 0) {
            System.out.println("error");
        } else {
            System.out.println(list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }
    }

    public int size() {
        return list.size();
    }
}

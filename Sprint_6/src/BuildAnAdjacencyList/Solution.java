package BuildAnAdjacencyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String[] s = reader.readLine().split(" ");
            Integer vertex = Integer.parseInt(s[0]);
            Integer edge = Integer.parseInt(s[1]);
            if (!hashMap.containsKey(vertex)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(edge);
                hashMap.put(vertex, list);
            } else {
                ArrayList<Integer> list = hashMap.get(vertex);
                list.add(edge);
                hashMap.put(vertex, list);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (hashMap.containsKey(i)) {
                ArrayList<Integer> edges = hashMap.get(i);
                System.out.print(edges.size() + " ");
                for (Integer edge : edges) {
                    System.out.print(edge + " ");
                }
                System.out.println();
            } else {
                System.out.println(0);
            }
        }
    }
}

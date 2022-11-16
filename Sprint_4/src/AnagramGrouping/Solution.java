package AnagramGrouping;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] words = reader.readLine().split(" ");

        LinkedHashMap<String, ArrayList<Integer>> map = new LinkedHashMap<>();

        for (int i = 0; i <= words.length - 1; i++) {
            char[] chars = words[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            ArrayList<Integer> value = map.get(key);
            if (value == null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(key, list);
            } else {
                ArrayList<Integer> list = map.get(key);
                list.add(i);
                map.put(key, list);
            }
        }

        for (ArrayList<Integer> list : map.values()) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

package Section;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = reader.readLine();
        }

        List<String> uniqueWords = Arrays.stream(words)
                .collect(Collectors.groupingBy(
                        w -> w, LinkedHashMap::new, Collectors.counting()
                ))
                .keySet()
                .stream().toList();

        for (String s : uniqueWords) {
            System.out.println(s);
        }
    }
}

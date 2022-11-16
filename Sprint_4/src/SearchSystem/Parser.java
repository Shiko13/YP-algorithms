package SearchSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

class Parser {
    Searcher searcher = new Searcher();

    public Map<String, Map<Integer, Integer>> parseDocuments(BufferedReader reader, int amountOfDocuments) throws IOException {
        final Map<String, Map<Integer, Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < amountOfDocuments; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            while (tokenizer.hasMoreTokens()) {
                String word = tokenizer.nextToken();
                if (hashMap.containsKey(word)) {
                    hashMap.get(word).put(i + 1, hashMap.get(word).getOrDefault(i + 1, 0) + 1);
                } else {
                    Map<Integer, Integer> integerHashMap = new HashMap<>();
                    integerHashMap.put(i + 1, 1);
                    hashMap.put(word, integerHashMap);
                }
            }
        }
        return hashMap;
    }

    public void parseRequest(BufferedReader reader, Map<String, Map<Integer, Integer>> hashMap, int amountOfRequest) throws IOException {
        for (int i = 0; i < amountOfRequest; i++) {
            Set<String> requestWithoutRepeat = Arrays.stream((reader.readLine().split(" ")))
                    .collect(Collectors.toSet());
            searcher.calculateRelevance(hashMap, requestWithoutRepeat);
        }
    }
}

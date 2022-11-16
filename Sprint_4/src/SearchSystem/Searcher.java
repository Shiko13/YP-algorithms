package SearchSystem;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Searcher {
    private static final int MAX_DOCUMENTS = 5;

    public void calculateRelevance(Map<String, Map<Integer, Integer>> hashMap, Set<String> request) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (String s : request) {
            if (hashMap.containsKey(s)) {
                Map<Integer, Integer> innerHashMap = hashMap.get(s);
                for (Integer i : innerHashMap.keySet()) {
                    map.put(i, map.getOrDefault(i, 0) + innerHashMap.get(i));
                }
            }
        }
        sortAndPrint(map);
    }

    private void sortAndPrint(Map<Integer, Integer> map) {
        map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(MAX_DOCUMENTS)
                .forEach(key -> {
                    if (key.getValue() != 0) {
                        System.out.print(key.getKey() + " ");
                    }
                });
        System.out.println();
    }
}
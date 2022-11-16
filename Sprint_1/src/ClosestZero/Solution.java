package ClosestZero;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine());
            List<Integer> list = readList(reader);
            printList(distanceToEmptyArea(list), writer);
        }
    }
    public static List<Integer> distanceToEmptyArea(List<Integer> list) {

        List<Integer> distance = new ArrayList<>(Collections.nCopies(list.size(), 0));

        int dist = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                dist = 0;
            }
            distance.set(i, dist);
            dist++;
        }

        dist = list.size();
        for (int j = list.size() - 1; j >= 0 ; j--) {
            if (list.get(j) == 0) {
                dist = 0;
            }
            distance.set(j, Math.min(distance.get(j), dist));
            dist++;
        }
        return distance;
    }
    public static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static <T> void printList(List<T> list, Writer writer) {
        list.forEach(elem -> {
                    try {
                        writer.write(String.valueOf(elem));
                        writer.write(" ");
                    } catch (IOException ignored) {
                    }
                }
        );
    }
}


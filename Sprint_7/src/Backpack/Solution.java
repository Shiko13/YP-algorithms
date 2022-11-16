package Backpack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int count = Integer.parseInt(str[0]);
        int maxWeight = Integer.parseInt(str[1]);

        int[] weights = new int[count];
        int[] prices = new int[count];

        for (int i = 0; i < count; i++) {
            String[] str2 = reader.readLine().split(" ");
            weights[i] = Integer.parseInt(str2[0]);
            prices[i] = Integer.parseInt(str2[1]);
        }

        int[][] A;
        A = new int[count + 1][];
        for (int i = 0; i < count + 1; i++) {
            A[i] = new int[maxWeight + 1];
        }

        for (int k = 0; k <= count; k++) {
            for (int s = 0; s <= maxWeight; s++) {
                if (k == 0 || s == 0) {
                    A[k][s] = 0;
                } else {
                    if (s >= weights[k - 1]) {
                        A[k][s] = Math.max(A[k - 1][s], A[k - 1][s - weights[k - 1]] + prices[k - 1]);
                    } else {
                        A[k][s] = A[k - 1][s];
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result(A, weights, count, maxWeight, result);

        System.out.println(result.size());
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

    private static void result(int[][] A, int[] weight, int k, int s, ArrayList<Integer> result) {
        if (A[k][s] == 0) {
            return;
        }
        if (A[k - 1][s] == A[k][s]) {
            result(A, weight, k - 1, s, result);
        } else {
            result(A, weight, k - 1, s - weight[k - 1], result);
            result.add(0, k);
        }
    }
}

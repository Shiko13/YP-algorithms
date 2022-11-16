package PrefixHashes;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int base;
        int mod;
        long[] hashArray;
        long[] powers;
        int quantity;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            base = Integer.parseInt(reader.readLine());
            mod = Integer.parseInt(reader.readLine());
            String str = reader.readLine();
            char[] letters = str.toCharArray();
            hashArray = new long[letters.length];
            hashArray[0] = letters[0] % mod;
            powers = new long[letters.length];
            powers[0] = 1;
            for (int i = 1; i < letters.length; i++) {
                hashArray[i] = hashArray[i - 1] * base % mod + letters[i] % mod;
                powers[i] = base * powers[i - 1] % mod;
            }
            quantity = Integer.parseInt(reader.readLine());
            for (int i = 0; i < quantity; i++) {
                String[] indexes = reader.readLine().split(" ");
                int startIndex = Integer.parseInt(indexes[0]);
                int endIndex = Integer.parseInt(indexes[1]);
                if (startIndex == 1) {
                    writer.write(hashArray[endIndex - 1] + "\n");
                } else if (startIndex == endIndex) {
                    writer.write((int) letters[startIndex - 1] + "\n");
                } else {
                    long hash = modal(hashArray[endIndex - 1] - (powers[endIndex + 1 - startIndex] * hashArray[startIndex - 2]) % mod, mod);
                    writer.write(hash + "\n");
                }
            }
        }
    }

    static long modal(long x, long m) {
        x = x % m;
        if (x < 0) {
            x = x + m;
        }
        return x;
    }
}

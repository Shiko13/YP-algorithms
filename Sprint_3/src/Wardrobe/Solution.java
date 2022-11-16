package Wardrobe;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n == 0) {
            return;
        }
        String[] array = reader.readLine().split(" ");
        reader.close();
        Sort(array);
    }

    static void Sort(String[] array) throws IOException {
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String s : array) {
            if (Integer.parseInt(s) == 0) {
                countZero++;
            } else if (Integer.parseInt(s) == 1) {
                countOne++;
            } else if (Integer.parseInt(s) == 2) {
                countTwo++;
            }
        }
        if (countZero > 0) {
            String zero = "0 ".repeat(countZero);
            writer.write(zero);
        }
        if (countOne > 0) {
            String one = "1 ".repeat(countOne);
            writer.write(one);
        }
        if (countTwo > 0) {
            String two = "2 ".repeat(countTwo);
            writer.write(two);
        }
        writer.flush();
    }
}

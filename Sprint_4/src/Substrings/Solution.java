package Substrings;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        System.out.println(withoutDuplication(str));
    }

    static int withoutDuplication(String str) {
        int count;
        int maxCount = 0;
        int begin = 0;
        int end = str.length() - 1;
        String max = "";

        while (begin <= end) {
            if (max.indexOf(str.charAt(begin)) == -1){
                max = max.concat(String.valueOf(str.charAt(begin)));
            } else {
                int index = max.indexOf(str.charAt(begin));
                max = max.substring(index + 1).concat(String.valueOf(str.charAt(begin)));
            }

            count = max.length();

            if (count > maxCount) {
                maxCount = count;
            }

            begin++;
        }
        return maxCount;
    }
}

package RecursiveFibonacciNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        System.out.println(s.fibo(a));
    }

    public int fibo(int a) {
        if (a == 0 || a == 1) {
            return 1;
        } else {
            return fibo(a - 1) + fibo(a - 2);
        }
    }
}

package BracketGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int control = 0;
        bracketGenerator(control, a, a, "");
    }

    public static void bracketGenerator(int control, int a, int b, String prefix) {
        if (a == 0 && b == 0) {
            System.out.println(prefix);
        } else {
            if (a > 0) {
                bracketGenerator(control + 1, a - 1, b, prefix + "(");
            }
            if (control > 0 && b > 0) {
                bracketGenerator(control - 1, a, b - 1, prefix + ")");
            }
        }
    }
}

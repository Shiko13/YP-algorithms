package BracketSequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        while (str.contains("{}") || str.contains("[]") || str.contains("()")) {
            str = str.replace("{}", "");
            str = str.replace("[]", "");
            str = str.replace("()", "");
        }
        if (str.equals("")) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}

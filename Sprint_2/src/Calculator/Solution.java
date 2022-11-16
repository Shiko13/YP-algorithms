package Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        System.out.println(calculate(str));
    }
    public static int calculate(String str) {
        int firstNumber;
        int secondNumber;
        StringTokenizer tokenizer = new StringTokenizer(str, " ");
        Stack<Integer> stack = new Stack<>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            switch (token) {
                case "+" -> {
                    firstNumber = stack.pop();
                    secondNumber = stack.pop();
                    stack.push(firstNumber + secondNumber);
                }
                case "-" -> {
                    firstNumber = stack.pop();
                    secondNumber = stack.pop();
                    stack.push(secondNumber - firstNumber);
                }
                case "*" -> {
                    firstNumber = stack.pop();
                    secondNumber = stack.pop();
                    stack.push(firstNumber * secondNumber);
                }
                case "/" -> {
                    firstNumber = stack.pop();
                    secondNumber = stack.pop();
                    double auxiliary = Math.floor((double) secondNumber / firstNumber);
                    stack.push((int) auxiliary);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}

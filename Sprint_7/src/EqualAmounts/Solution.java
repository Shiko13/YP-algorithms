package EqualAmounts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
ID посылки: https://contest.yandex.ru/contest/25597/run-report/69781656/
Тут в чём-то аналогичное решение - заполнение матрицы (по сути) true/false, по сути это задача
о разбиении множества множества чисел (псевдополиномиальный алгоритм). Решение с матрицей у меня
не прошло по одному тесту, по подсказке наставника свёл всё к 1D-массиву.
Временная сложность: О(n*k), где n - количество партий, а k - половина суммы.
Пространственная сложность: О(k).
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] numbers = new int[n];
        final StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
            sum += numbers[i];
        }

        if (sum % 2 != 0) {
            System.out.println("False");
            return;
        }

        if (isDividePossible(numbers, sum)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    private static boolean isDividePossible(int[] numbers, Integer sum) {
        int halfSum = sum / 2;
        boolean[] dp = new boolean[halfSum + 1];

        for (int i = 0; i <= halfSum; i++) {
            dp[i] = false;
        }

        for (Integer number : numbers) {
            for (int j = halfSum; j >= number; j--) {
                if (dp[j - number] || j == number)
                    dp[j] = true;
            }
        }
        return dp[halfSum];
    }
}

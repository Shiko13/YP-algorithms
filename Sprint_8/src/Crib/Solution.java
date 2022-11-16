package Crib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
ID посылки: https://contest.yandex.ru/contest/26133/run-report/69970177/
    Создаём префиксное дерево, в узлах храним информацию, является ли узел концом слова.
    Затем создаём массив, равный длине шпаргалки + 1,в первый узел записываем true, в остальных
    запишем false. Элементы массива с 1 по последний будут обозначать, является ил подстрока шпаргалки
    концом слова. Проходим по всей шпаргалке, если последний элемент массива в конце станет true,
    тогда из этих слов можно собрать шпаргалку.
    Временная сложность: тут тоже не всё так просто. На построение дерева уходит О(L), где L - количество
    всех букв в словах. Вроде бы из-за того, что храним узлы в мапе, то сложность поиска узла занимает
    О(n) в среднем, где n - длина слова. Так что я бы сказал, что проход по шпаргалке займёт O(m * n),
    где m - длина шпаргалки.
    Пространственная сложность: помимо хранения шпаргалки O(m) мы дополнительно храним дерево,
    чью сложность я бы оценил как O(L) в худшем случае, а также массив O(L).
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String cheatSheet = reader.readLine();
        int n = Integer.parseInt(reader.readLine());
        String[] lines = new String[n];

        for (int i = 0; i < n; i++) {
            lines[i] = (reader.readLine());
        }

        if (result(lines, cheatSheet)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean result(String[] lines, String word) {
        Trie trie = new Trie();

        for (String line : lines) {
            trie.insert(line);
        }

        Boolean[] dp = new Boolean[word.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int i = 0; i < word.length(); i++) {
            TrieNode node = trie.getRoot();
            if (dp[i]) {
                for (int j = i; j < word.length() + 1; j++) {
                    if (node.isEndOfWord()) {
                        dp[j] = true;
                    }
                    if (j == word.length() || node.getChildren().get(word.charAt(j)) == null) {
                        break;
                    }
                    node = node.getChildren().get(word.charAt(j));
                }
            }
        }
        return dp[word.length()];
    }
}


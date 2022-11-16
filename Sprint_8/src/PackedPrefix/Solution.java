package PackedPrefix;

import java.io.*;

/*
    ID посылки: https://contest.yandex.ru/contest/26133/run-report/70038565/
    Сначала распаковываем каждую строку, после чего последовательно находим наибольший
    общий префикс у строк (от первой к последней).
    Временная сложность: что-то очень сложно её посчитать, поскольку распаковка каждой из строк
    занимает непредсказуемое время. Если не учитывать её, то временная сложность алгоритма
    вроде бы О(n * m), где n - количество слов, а m - длина самого длинного слова, поскольку мы проходим по всем словам и в каждом можем в худшем случае пройти
    до конца слова (если слова одинаковые). В худшем случае распаковка строки может занять ещё где-то
    О(m), наверное.
    Пространственная сложность: помимо хранения самих слов мы храним префикс, который не больше О(m).
 */

public class Solution {
    static int min;
    static int n;
    static int pos;
    static String prefix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());

        String[] strings = new String[n];
        int startIndex = 0;

        prefix = strings[0] = unpacking(reader.readLine(), startIndex);
        min = prefix.length();

        for (int i = 1; i < n; i++) {
            strings[i] = unpacking(reader.readLine(), startIndex);
            if (strings[i].length() < min) {
                min = prefix.length();
            }
        }

        System.out.println(longestCommonPrefix(strings));
    }

    public static String longestCommonPrefix(String[] strings) {
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < min; i++) {
            for (int j = 1; j < n; j++) {
                if (strings[j].charAt(i) != prefix.charAt(i)) {
                    min = i;
                    break;
                }
            }
        }

        for (int i = 0; i < min; i++) {
            sb.append(prefix.charAt(i));
        }
        return sb.toString();
    }

    private static String unpacking(String inputString, int position) {
        pos = position;
        StringBuilder outputString = new StringBuilder("");

        while (pos < inputString.length() && inputString.charAt(pos) != ']') {
            if (!Character.isDigit(inputString.charAt(pos))) {
                if (inputString.charAt(pos) != '[') {
                    outputString.append(inputString.charAt(pos));
                }
            } else {
                int indexStartDigit = pos;
                String currentParsed = unpacking(inputString, ++pos);
                int coefficient = Character.getNumericValue(inputString.charAt(indexStartDigit));

                outputString.append(currentParsed.repeat(Math.max(0, coefficient)));
            }
            pos++;
        }
        return outputString.toString();
    }
}

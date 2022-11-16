package LevenshteinDistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
ID посылки: https://contest.yandex.ru/contest/25597/run-report/69742744/
Для решения воспользовался алгоритмом Вагнера - Фишера. Так как нам не нужно восстанавливать
путь, а надо только найти расстояние, можно сократить объём потребляемой памяти и вместо
матрицы m*n (m и n - длины строк) хранить два массива длины m или n.
Временная сложность: O(m * n), так как мы по сути проходимся циклом по матрице m*n.
Пространственная сложность: O(m) или O(n) - сейчас я просто выбираю размер массива по длине второй
строки + 1, соответственно, если длина строки m, то цикл будет n. Вероятно, есть смысл определить
длину наибольшей строки, чтобы размер массива брать от неё, чтобы число в цикле было меньше. Хотел у тебя
спросить - есть ли в этом смысл? В том плане, что я не могу понять, есть ли тут разница в перестановке для
скорости работы.
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String t = reader.readLine();
        System.out.println(levenshteinDistance(s, t));
    }

    private static Integer levenshteinDistance(String s, String t) {
        Integer size = t.length() + 1;
        Integer[] D1 = new Integer[size];
        Integer[] D2 = new Integer[size];

        for (int i = 0; i <= t.length(); i++) {
            D2[i] = i;
        }

        for (int i = 1; i <= s.length(); i++) {
            System.arraycopy(D2, 0, D1, 0, D1.length);

            D2[0] = i;
            for (int j = 1; j <= t.length(); j++) {
                Integer cost;
                if (s.charAt(i - 1) != t.charAt(j - 1)) {
                    cost = 1;
                } else {
                    cost = 0;
                }
                D2[j] = findMin(D1[j] + 1, D2[j - 1] + 1, D1[j - 1] + cost);
            }
        }
        return D2[D2.length - 1];
    }

    private static Integer findMin(Integer i1, Integer i2, Integer i3) {
        return Math.min(Math.min(i1, i2), i3);
    }
}

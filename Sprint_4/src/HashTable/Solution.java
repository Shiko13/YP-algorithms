package HashTable;

import java.io.*;
import java.util.StringTokenizer;

/*Ссылка на отчёт: https://contest.yandex.ru/contest/24414/run-report/69335602/
Итак, в программе я реализовал свою HashMap, размер рассчитал, исходя из максимальной подачи - 100000.
Взял коэффициент заполнения в 0.75 (насколько я понимаю, в Java такой и используется по умолчанию), рассчитал
100000 / 0.75 и выбрал ближайшее к нему простое число, чтобы затем более равномерно раскидывать числа по корзине.
Хэш-функцию рассчитываю довольно наивным способом - беру остаток от деления приходящего значения на число корзин.
Разрешение коллизий осуществил методом цепочек.
Временная сложность: насколько я понимаю, она зависит от удачной реализации корзин и в лучшем случае составляет
О(1) в среднем, в худшем - О(n), но простое число, взятое за основу, должно давать нормальное раскидывание по корзинам, так
что в моём случае в среднем это О(1).
Пространственная сложность: зависит от начального размера HashMap, то есть О(n).
 */

public class Solution {
    private static final int VOLUME = 133337;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

            int requestAmount = Integer.parseInt(reader.readLine());
            MyHashMap myHashMap = new MyHashMap(VOLUME);

            for (int i = 0; i < requestAmount; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
                switch (tokenizer.nextToken()) {
                    case "get" -> {
                        int key = Integer.parseInt(tokenizer.nextToken());
                        if (myHashMap.getKey(key) == null) {
                            writer.write("None" + "\n");
                        } else {
                            writer.write(myHashMap.getKey(key).toString() + "\n");
                        }
                    }
                    case "put" -> {
                        int key2 = Integer.parseInt(tokenizer.nextToken());
                        int value = Integer.parseInt(tokenizer.nextToken());
                        myHashMap.put(key2, value);
                    }
                    case "delete" -> {
                        int key3 = Integer.parseInt(tokenizer.nextToken());
                        if (myHashMap.getKey(key3) != null) {
                            writer.write(myHashMap.getKey(key3).toString() + "\n");
                            myHashMap.deleteKey(key3);
                        } else {
                            writer.write("None" + "\n");
                        }
                    }
                }
            }
            writer.close();
        }
    }
}

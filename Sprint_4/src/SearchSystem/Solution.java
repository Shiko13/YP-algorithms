package SearchSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Ссылка на отчёт: https://contest.yandex.ru/contest/24414/run-report/69335583/
В этой задаче во время считывания документов собираю их в мапу, в которой ключами являются отдельные
слова, а значением - ещё одна мапа (здравствуй, Нолан). Во внутренней мапе ключ - номер строки, значение -
счётчик, то есть то количество, которое ключ-слово внешней мапы встречается в строке.
С определением сложности у меня пока есть затруднения, надеюсь, что вебинар, который у нас будет посвящён
этой теме в среду, внесёт ясность, но попробую.
UPD: ага, я осознал, что во временной сложности забыл домножать на количество слов
Временная сложность: HashMap позволяет в лучшем случае (и среднем, как я понимаю) находить элемент
за О(1), у нас есть вложенная HashMap, но О(1) внутри О(1) - это, видимо О(1), так что я оценил бы
временную сложность одной операции как О(1). Мапу создаём за один проход, так что сложность построения
индекса - О(n * k). Для получения каждого запроса сначала проходимся целиком по данным, выходит O(m * k1), который
загоняем в TreeMap, что даёт ещё log(m). Ну и в финале сортируем через стрим. Насколько я прочитал, эта
встроенная сортировка в худшем случае работает за O(m * log(m)). Итого выходит O(m * log(m)).
Суммарно выходит О(n * k) + O(m * k1) + O(m * log(m)), ну или если я упрощаю как в пространственной и приравниваю k к k1,
то О((m + n) * k) + O(m * log(m)).
Пространственная сложность: n - количество документов, но я храню каждое слово этого документа в мапе, а слова
в теории могут все быть уникальными, так что если взять максимальное число в документе за k, то для первой
части программы сложность оценил бы как О(n * k), а для запросов создаю мапу размером примерно О(m * k1), где k1 -
среднее число слов в запросе. По итогу k и k1 упростил бы до k и программную сложность тогда оценил бы в O((m + n)*k),
а алгоритмическую - в О(n * k). (Я признаться, не до конца понял твой коммент к пространственной сложности в
последнем ревью - там как будто вперемешку о временной и пространственной сложности говорится, но, когда рассчитываю
алгоритмическую сложность, делаю так - подсчитываю сперва программную просранственную сложность, от неё отнимаю то, что
не относится к алгоритму, то есть считывание и вывод данных).
 */

class Solution {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int amountOfDocuments = Integer.parseInt(reader.readLine());
            Map<String, Map<Integer, Integer>> hashMap = parser.parseDocuments(reader, amountOfDocuments);

            int amountOfRequest = Integer.parseInt(reader.readLine());
            parser.parseRequest(reader, hashMap, amountOfRequest);
        }
    }
}

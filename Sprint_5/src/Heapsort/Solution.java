package Heapsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/*
    При решении этой задачи я переделал код той же задачи из третьего спринта.
    Считанные данные храню в дереве в виде массива (нумерация с 0). Обход начинаю с последнего
    элемента, у которого есть потомки. Проходимся от этого элемента до корня, сравнивая узел с
    его потомками. Если потомок меньше, меняем его местами с узлом. В конце цикла в корне окажется
    минимальное значение. Затем проводим последний цикл сортировки, начиная с последнего элемента.
    Обмениваем его с корнем и снова проводим сравнение корня с потомком на предмет обмена, чтобы в
    корне всегда оказывался новый минимум. Таким образом, после серии обменов и сортировки массив
    окажется отсортирован по убыванию.
    Пространственная сложность: данные считываются в О(n), дополнительной памяти не требуется,
    данные хранятся в массиве, в нём же и хранятся, меняясь друг с другом местами. Разве что надо
    выделить О(1) для обмена этих данных (добавление третьей вспомогательной переменной для обмена
    между собой двух значений).
    Временная сложность: сортировка происходит дважды, каждый раз за О(n*log(n)), так что итоговая
    временная сложность такая же - О(n*log(n)).
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int traineeNumber = Integer.parseInt(reader.readLine());
        Person[] persons = new Person[traineeNumber];

        for (int i = 0; i < traineeNumber; i++) {
            String[] str = reader.readLine().split(" ");
            persons[i] = new Person(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]));
        }
        reader.close();

        Sorting sorting = new Sorting();
        ArrayList<Person> sortList = sorting.pyramidalSort(persons);

        for (Person person : sortList) {
            person.printName();
        }
    }
}

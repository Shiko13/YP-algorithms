package EfficientQuickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* ID посылки: https://contest.yandex.ru/contest/23815/run-report/69089125/
Моя программа считывает данные в двумерный массив строк. Один из подмассива выбирается опорным
(я выбрал нулевой). Указатели изначально стоят на первом и последнем подмассиве, в цикле они сравниваются
с опорным. Ближе к нулевому элементу у меня будут располагаться бо́льшие значения, ближе к концу — меньшие.
Если левый указатель указывает на элемент, больший опорного, то так и  надо, указатель передвигается дальше.
То же самое с правым указателем, только он должен быть меньше опорного. Левые указатели, которые указывает на
подмассив меньше опорного обмениваем с правыми указателями, которые указывают на подмассив больше опорного
(не нашёл в Java функцию swap(), потому ввёл дополнительный массив temp).
Когда указатели пересеклись, обращаемся к опорному подмассиву, который ставим на место пересечения указателей.
Дальше рекурсивно повторяем процедуру для того, чтобы уже отсортировать элементы слева от опорного и справа от него
(сами элементы были раскиданы на большие и меньшие, но без сортировки по порядку).
Для сравнения массивов был написан класс, в котором парсятся очки и штрафы, после чего происходит сравнение
по приоритету (очки, штрафы, алфавитный порядок).
Временная сложность в худшем случае будет O(n^2), в среднем — О(n*log(n)).
Пространственную сложность всей программы оценил бы в О(n), поскольку после считывания массива только обмениваю местами
подмассивы (разве что ещё создаю массив temp, но им можно пренебречь), а алгоритмическую составляющую — в О(1).
 */

public class Main {

    public static void main(String[] args) throws IOException {
        Sorting sorting = new Sorting();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int traineeNumber = Integer.parseInt(reader.readLine());
        Person[] persons = new Person[traineeNumber];

        for (int i = 0; i < traineeNumber; i++) {
            String[] str = reader.readLine().split(" ");
            persons[i] = new Person(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]));
        }
        reader.close();

        int right = persons.length;
        int left = 0;

        sorting.sort(persons, left, right);

        for (Person person : persons) {
            person.printName();
        }
    }
}

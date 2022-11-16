package ExpensiveNetwork;

import java.io.*;
import java.util.*;

/*
    ID посылки: https://contest.yandex.ru/contest/25070/run-report/69692144/
    Для хранения пула рёбер изучал такую структуру как приоритетная очередь - очень крутая штука :)
    Для начала рассматриваю крайние случаи - если 1 вершина и 0 рёбер, то, очевидно, максимальный размер
    остовного дерева (из одной вершины) - 0. Если же вершин больше 1, то у нас просто разрозненные
    вершины, из которых не сделать остовное дерево.
    Для хранение пары вершины - ребро создал класс, который назвал Node, но это не лучшее название, думаю.
    Создаю лист со всеми вершинами, из этого листа буду со временем удалять обработанные вершины и
    перекладывать в лист к отработанным (который пока пустой).
    Дальше реализую алгоритм Прима из теории, начинаю обход с первой вершины - все связанные с ней пары ребро - вершина
    добавляю в приоритетную очередь, откуда буду забирать сверху, где будет находиться самый дорогой узел,
    если его вершины ещё нет в добавленной.
    Временная сложность: поскольку используется приоритетная очередь, то сложность  O(n*log(m)).
    Пространственная сложность: я храню список узлов O(n*m), а также список вершин O(n), так что
    O(n*m) + О(n).
 */

public class Solution {
    static List<Boolean> isAdded;
    static HashMap<Integer, ArrayList<Node>> graph = new HashMap<>();
    static Integer weight = 0;
    static PriorityQueue<Node> edges = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        isAdded = new ArrayList<>(Collections.nCopies(n, false));

        if (m == 0) {
            if (n == 1) {
                System.out.print(0);
            } else {
                System.out.print("Oops! I did it again");
            }
            return;
        }

        util(reader, m);
        findMST();
    }

    private static void findMST() {
        addVertex(1);
        while (isAdded.contains(false) && !edges.isEmpty()) {
            Node node = edges.poll();
            if (isAdded.get(node.vertex - 1).equals(false)) {
                weight += node.edge;
                addVertex(node.vertex);
            }
        }
        if (!isAdded.contains(false)) {
            System.out.print(weight);
        } else {
            System.out.print("Oops! I did it again");
        }
    }

    public static void addVertex(Integer v) {
        isAdded.set(v - 1, true);

        for (Node node : graph.get(v)) {
            if (!isAdded.get(v - 1).equals(false)) {
                edges.add(node);
            }
        }
    }

    private static void util(BufferedReader reader, Integer m) throws IOException {
        for (int i = 0; i < m; i++) {
            int f = 0;
            int t = 0;
            int w = 0;
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            while (st.hasMoreTokens()) {
                f = Integer.parseInt(st.nextToken());
                t = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());
            }

            graph.computeIfAbsent(f, k -> new ArrayList<>()).add(new Node(t, w));
            graph.computeIfAbsent(t, k -> new ArrayList<>()).add(new Node(f, w));
        }
    }
}

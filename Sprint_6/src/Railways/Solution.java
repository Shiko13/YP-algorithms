package Railways;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    ID посылки: https://contest.yandex.ru/contest/25070/run-report/69698014/
    У нас выходит ориентированный граф, при этом ориентированный в одну сторону. Но если
    сменить направление ориентации одного из типов дорог, то можно будет проверить граф
    на наличие циклов — если цикла нет, то граф оптимальный, поскольку цикл возможен только при
    сочетании двух типов дорог, которые ведут в одну сторону и другую. Таким образом, сперва нужно
    как-то сменить ориентацию одного из типов дорог, а дальше реализовать поиск цикла в графе.
    Я решил реализовать хранение в матрице смежности. Понимаю, что это не так оптимально по памяти,
    ибо граф у нас разреженный (заполнен на 50%, считай), зато один из типов дорог сразу удобно
    реверсировать — вместо [i][j] ячейки кидаю её в [j][i]. Ну и в матрице можно быстро получить
    исходящие от вершины рёбра.
    Дальше, собственно, ищем цикл, как расписано в теории — подкрашиваем вершины в цвета. Изначально
    все в белый, затем при посещении перекрашиваем в серый, а при полной обработке — в чёрный. Если
    мы из серой вершины попали в серую, значит вошли в цикл.
    Пространственная сложность: O(n^2), где n — количество вершин, поскольку данные хранятся в матрице.
    Временная сложность: O(n+m), где n - количество вершин, а m - количество рёбер. Входим в кажду вершину по одному
    разу, в ней рассматриваем только те значения, которые не null, то есть все рёбра этой вершины.
 */

public class Solution {
    private static boolean isOptimal = true;
    private static int n;
    private static final char R = 'R';

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        Graph graph = new Graph(n);
        createMatrix(reader, graph);

        for (int i = 1; i < n; i++) {
            if (graph.colors[i] == Color.WHITE) {
                graph.dfs(i);
            }
        }

        if (isOptimal) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static class Graph {
        int size;
        boolean[][] matrix;
        Color[] colors;

        public Graph(final int n) {
            this.size = n + 1;
            this.matrix = new boolean[size][size];
            this.colors = new Color[size];

            for (int i = 0; i < size; i++) {
                colors[i] = Color.WHITE;
            }
        }

        public void addEdge(final int source, final int destination) {
            matrix[source][destination] = true;
        }

        public void dfs(Integer v) {
            colors[v] = Color.GREY;
            for (int i = 1; i <= n; i++) {
                if (matrix[v][i]) {
                    if (colors[i] == Color.GREY) {
                        isOptimal = false;
                        return;
                    }
                    if (colors[i] == Color.WHITE) {
                        dfs(i);
                    }
                }
            }
            colors[v] = Color.BLACK;
        }
    }

    private static void createMatrix(BufferedReader reader, Graph graph) throws IOException {
        for (int i = 1; i < n; i++) {
            char[] roadTypes = reader.readLine().toCharArray();
            for (int j = 0; j < n - i; j++) {
                char curr = roadTypes[j];
                if (curr == R) {
                    graph.addEdge(i, i + j + 1);
                } else {
                    graph.addEdge(i + j + 1, i);
                }
            }
        }
    }
}

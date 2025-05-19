import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[][] adjMatrix = new int[n][n];

        // Чтение матрицы смежности
        for (int i = 0; i < n; i++) {
            String[] parts = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = Integer.parseInt(parts[j]);
            }
        }

        String[] se = reader.readLine().split(" ");
        int start = Integer.parseInt(se[0]) - 1; // Переводим в 0-индексацию
        int end = Integer.parseInt(se[1]) - 1;

        // Обработка случая, когда начальная и конечная вершины совпадают
        if (start == end) {
            writer.write("0\n");
            reader.close();
            writer.close();
            return;
        }

        // BFS для поиска кратчайшего пути
        int[] parent = new int[n]; // Для хранения пути
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        parent[start] = start;

        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int current = queue.poll();

            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (adjMatrix[current][neighbor] == 1 && parent[neighbor] == -1) {
                    parent[neighbor] = current;
                    queue.add(neighbor);

                    if (neighbor == end) {
                        found = true;
                        break;
                    }
                }
            }
        }

        if (!found) {
            writer.write("-1\n");
        } else {
            // Восстановление пути
            List<Integer> path = new ArrayList<>();
            int node = end;
            while (node != start) {
                path.add(node + 1); // Переводим обратно в 1-индексацию
                node = parent[node];
            }
            path.add(start + 1);
            Collections.reverse(path);

            // Вывод длины пути
            writer.write((path.size() - 1) + "\n");

            // Вывод самого пути, если его длина > 0
            if (path.size() - 1 > 0) {
                for (int i = 0; i < path.size(); i++) {
                    if (i > 0) writer.write(" ");
                    writer.write(String.valueOf(path.get(i)));
                }
                writer.write("\n");
            }
        }

        reader.close();
        writer.close();
    }
}

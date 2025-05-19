import java.util.*;

public class ConnectedComponents {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // Создаем список смежности
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        boolean[] visited = new boolean[N + 1];
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, adjacencyList, visited, component);
                components.add(component);
            }
        }

        // Вывод результатов
        System.out.println(components.size());
        for (List<Integer> component : components) {
            System.out.println(component.size());
            for (int vertex : component) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int vertex, List<List<Integer>> adjacencyList, boolean[] visited, List<Integer> component) {
        visited[vertex] = true;
        component.add(vertex);

        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjacencyList, visited, component);
            }
        }
    }
}

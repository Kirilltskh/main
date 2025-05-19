import java.util.*;

public class CycleDetection {

    private static List<Integer> cycle;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] adjMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = scanner.nextInt();
            }
        }

        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        boolean hasCycle = false;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adjMatrix, visited, parent)) {
                    hasCycle = true;
                    break;
                }
            }
        }

        if (hasCycle) {
            System.out.println("YES");
            System.out.println(cycle.size());
            for (int i = 0; i < cycle.size(); i++) {
                System.out.print((cycle.get(i) + 1) + (i < cycle.size() - 1 ? " " : ""));
            }
        } else {
            System.out.println("NO");
        }
    }

    public static boolean dfs(int vertex, int parentVertex, int[][] adjMatrix, boolean[] visited, int[] parent) {
        visited[vertex] = true;

        for (int neighbor = 0; neighbor < adjMatrix.length; neighbor++) {
            if (adjMatrix[vertex][neighbor] == 1) {
                if (!visited[neighbor]) {
                    parent[neighbor] = vertex;
                    if (dfs(neighbor, vertex, adjMatrix, visited, parent)) {
                        return true;
                    }
                } else if (neighbor != parentVertex) {
               
                    cycle = new ArrayList<>();
                    int current = vertex;
                    while (current != neighbor) {
                        cycle.add(current);
                        current = parent[current];
                    }
                    cycle.add(neighbor);
                    Collections.reverse(cycle);
                    return true;
                }
            }
        }
        return false;
    }
}

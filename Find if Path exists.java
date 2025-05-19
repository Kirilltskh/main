import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Если source и destination совпадают
        if (source == destination) {
            return true;
        }
        
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }
      
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        visited[source] = true;
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            
            for (int neighbor : adjacencyList.get(current)) {
                if (neighbor == destination) {
                    return true;
                }
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
        
        return false;
    }
}

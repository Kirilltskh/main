import java.util.Scanner;

public class MazeRoomArea {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); // Переход на новую строку после чтения числа

        char[][] maze = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            maze[i] = line.toCharArray();
        }

        int startRow = scanner.nextInt() - 1; // Преобразование в индекс массива
        int startCol = scanner.nextInt() - 1;

        System.out.println(calculateRoomArea(maze, startRow, startCol));
    }

    public static int calculateRoomArea(char[][] maze, int startRow, int startCol) {
        if (maze[startRow][startCol] != '.') {
            return 0;
        }

        int area = 0;
        int N = maze.length;
        boolean[][] visited = new boolean[N][N];

        // Используем стек для DFS
        java.util.Stack<int[]> stack = new java.util.Stack<>();
        stack.push(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Направления: вверх, вниз, влево, вправо

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            area++;

            for (int[] dir : directions) {
                int newRow = current[0] + dir[0];
                int newCol = current[1] + dir[1];

                if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N) {
                    if (maze[newRow][newCol] == '.' && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        stack.push(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return area;
    }
}

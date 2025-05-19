import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Node root = null;
        String[] numbers = reader.readLine().split(" ");

        // Построение дерева
        for (String numStr : numbers) {
            int num = Integer.parseInt(numStr);
            if (num == 0) break;
            root = insert(root, num);
        }

        // Сбор вершин с одним ребёнком
        List<Integer> nodesWithOneChild = new ArrayList<>();
        collectNodesWithOneChild(root, nodesWithOneChild);

        // Сортировка и вывод
        Collections.sort(nodesWithOneChild);
        for (int nodeValue : nodesWithOneChild) {
            writer.write(nodeValue + "\n");
        }

        reader.close();
        writer.close();
    }

    private static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    private static void collectNodesWithOneChild(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }

        // Проверяем, что у узла ровно один ребёнок
        if ((node.left != null && node.right == null) || 
            (node.left == null && node.right != null)) {
            result.add(node.value);
        }

        // Рекурсивный обход левого и правого поддеревьев
        collectNodesWithOneChild(node.left, result);
        collectNodesWithOneChild(node.right, result);
    }
}

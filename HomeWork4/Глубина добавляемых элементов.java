import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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
        List<Integer> depths = new ArrayList<>();

        for (String numStr : numbers) {
            int num = Integer.parseInt(numStr);
            if (num == 0) break;
            
            if (root == null) {
                root = new Node(num);
                depths.add(1);
            } else {
                int depth = insertAndGetDepth(root, num, 1);
                if (depth != -1) {
                    depths.add(depth);
                }
            }
        }

        for (int i = 0; i < depths.size(); i++) {
            if (i > 0) writer.write(" ");
            writer.write(String.valueOf(depths.get(i)));
        }

        reader.close();
        writer.close();
    }

    private static int insertAndGetDepth(Node node, int value, int currentDepth) {
        if (value < node.value) {
            if (node.left == null) {
                node.left = new Node(value);
                return currentDepth + 1;
            } else {
                return insertAndGetDepth(node.left, value, currentDepth + 1);
            }
        } else if (value > node.value) {
            if (node.right == null) {
                node.right = new Node(value);
                return currentDepth + 1;
            } else {
                return insertAndGetDepth(node.right, value, currentDepth + 1);
            }
        } else {
            return -1; // Элемент уже существует
        }
    }
}

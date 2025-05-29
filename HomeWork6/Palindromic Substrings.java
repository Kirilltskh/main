mport java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> customers = new TreeMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue; // Пропускаем пустые строки
            }
            
            String[] parts = line.split(" ");
            if (parts.length != 3) {
                continue; // Пропускаем некорректные строки
            }
            
            try {
                String customer = parts[0];
                String product = parts[1];
                int quantity = Integer.parseInt(parts[2]);

                customers.putIfAbsent(customer, new TreeMap<>());
                customers.get(customer).merge(product, quantity, Integer::sum);
            } catch (NumberFormatException e) {
                continue; // Пропускаем строки с некорректным количеством
            }
        }

        for (Map.Entry<String, Map<String, Integer>> entry : customers.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Map.Entry<String, Integer> productEntry : entry.getValue().entrySet()) {
                System.out.println(productEntry.getKey() + " " + productEntry.getValue());
            }
        }
    }
}

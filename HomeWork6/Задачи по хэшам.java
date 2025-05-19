import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

   
        StringBuilder textBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            textBuilder.append(line).append(" ");
        }
        String text = textBuilder.toString().trim();

    
        String[] words = text.split("\\s+");

       
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

       
        String mostFrequentWord = "";
        int maxCount = 0;
        
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            
            if (count > maxCount || 
                (count == maxCount && word.compareTo(mostFrequentWord) < 0)) {
                mostFrequentWord = word;
                maxCount = count;
            }
        }

        writer.write(mostFrequentWord);
        writer.newLine();

        reader.close();
        writer.close();
    }
}

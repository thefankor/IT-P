package lab6;

import java.io.File;
import java.io.FileNotFoundException; 
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "lab6/text.txt";
        File file = new File(filePath);
        // создаем объект Scanner для чтения файла Scanner scanner = null;
        Scanner scanner = null;
        Map<String, Integer> wordCountMap = new HashMap<>();

        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[,\\.]*", "");
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
            
        } catch (FileNotFoundException e) { 
            e.printStackTrace();
        } finally {
            scanner.close();
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCountMap.entrySet());

        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry2.getValue().compareTo(entry1.getValue());
            }
        });
        System.out.println("Топ-10 слов:");
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}

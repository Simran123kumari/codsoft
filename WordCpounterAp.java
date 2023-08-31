import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCpounterAp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Word Counter");
        System.out.println("1. Enter text manually");
        System.out.println("2. Provide a file");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        
        String text = "";
        switch (choice) {
            case 1:
                System.out.println("Enter your text (type 'end' on a new line to finish):");
                String line;
                while (!(line = scanner.nextLine()).equals("end")) {
                    text += line + " ";
                }
                break;
            case 2:
                System.out.print("Enter the file path: ");
                String filePath = scanner.nextLine();
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(filePath));
                    String lineRead;
                    while ((lineRead = reader.readLine()) != null) {
                        text += lineRead + " ";
                    }
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error reading the file.");
                    System.exit(1);
                }
                break;
            default:
                System.out.println("Invalid choice.");
                System.exit(1);
        }
        
        String[] words = text.split("[\\s\\p{Punct}]+");
        int wordCount = words.length;
        
        System.out.println("Total words: " + wordCount);
        
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        
        System.out.println("Word Frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        scanner.close();
    }
}

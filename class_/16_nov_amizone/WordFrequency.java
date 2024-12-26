import java.util.HashMap;
import java.util.Scanner;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a line of text:");
        String text = sc.nextLine().toLowerCase();

        String[] words = text.split("\\s+|\\p{Punct}+");
        HashMap<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println("Word frequencies:");
        for (String word : frequencyMap.keySet()) {
            System.out.println(word + ": " + frequencyMap.get(word));
        }
        sc.close();
    }
}

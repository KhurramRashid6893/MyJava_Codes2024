import java.io.*;
import java.util.Scanner;

public class FileStats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read file name from user
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        // Variables to hold counts
        int charCount = 0;
        int wordCount = 0;
        int lineCount = 0;

        // Try to read the file
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                wordCount += line.split("\\s+").length; // Split by whitespace to count words
            }

            System.out.println("Characters: " + charCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Lines: " + lineCount);

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error: An IO error occurred.");
        }

        scanner.close();
    }
}

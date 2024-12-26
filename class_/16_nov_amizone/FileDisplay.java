import java.io.*;
import java.util.Scanner;

public class FileDisplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read file name from user
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        // Try to read the file
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 1;

            while ((line = br.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error: An IO error occurred.");
        }

        scanner.close();
    }
}

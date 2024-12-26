import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        // Source and destination file paths
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        // Try-with-resources to automatically close streams
        try (FileReader fileReader = new FileReader(sourceFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(destinationFile);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine(); // Maintain line breaks
            }

            System.out.println("File copied successfully from " + sourceFile + " to " + destinationFile);

        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file not found. Please check the file path.");
        } catch (IOException e) {
            System.out.println("Error: An IO error occurred while reading or writing the file.");
        }
    }
}

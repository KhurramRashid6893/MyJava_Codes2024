import java.io.File;
import java.util.Scanner;

public class FileInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read file name from user
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        // Create a File object
        File file = new File(fileName);

        // Check and display file properties
        if (file.exists()) {
            System.out.println("File exists: Yes");
            System.out.println("Readable: " + (file.canRead() ? "Yes" : "No"));
            System.out.println("Writable: " + (file.canWrite() ? "Yes" : "No"));
            System.out.println("Type: " + (file.isFile() ? "File" : "Directory"));
            System.out.println("Length: " + file.length() + " bytes");
        } else {
            System.out.println("File does not exist.");
        }

        scanner.close();
    }
}

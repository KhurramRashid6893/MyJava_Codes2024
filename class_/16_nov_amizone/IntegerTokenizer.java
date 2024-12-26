import java.util.StringTokenizer;
import java.util.Scanner;

public class IntegerTokenizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a line of integers (space-separated):");
        String line = sc.nextLine();

        StringTokenizer st = new StringTokenizer(line);
        int sum = 0;

        System.out.println("Integers are:");
        while (st.hasMoreTokens()) {
            try {
                int num = Integer.parseInt(st.nextToken());
                System.out.println(num);
                sum += num;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input encountered. Skipping...");
            }
        }

        System.out.println("Sum of integers: " + sum);
        sc.close();
    }
}


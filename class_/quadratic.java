import java.util.Scanner;

public class quadratic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading input for a, b, and c
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();

        // Calculating the discriminant
        double discriminant = b * b - 4 * a * c;

        // Checking the nature of the discriminant
        if (discriminant > 0) {
            // Two real and distinct roots
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("The roots are real and distinct:");
            System.out.println("Root 1: " + root1);
            System.out.println("Root 2: " + root2);
        } else if (discriminant == 0) {
            // One real root
            double root = -b / (2 * a);
            System.out.println("The root is real and repeated:");
            System.out.println("Root: " + root);
        } else {
            // No real roots
            System.out.println("There are no real solutions.");
        }

        scanner.close(); // Closing the scanner
    }
}

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the start limit: ");
        int start = scanner.nextInt();
        
        System.out.print("Enter the end limit: ");
        int end = scanner.nextInt();
        
        System.out.println("Prime numbers between " + start + " and " + end + " are:");
        
        for (int num = start; num <= end; num++) {
            if (isPrime(num)) {
                System.out.println(num);
            }
        }
    }
    
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

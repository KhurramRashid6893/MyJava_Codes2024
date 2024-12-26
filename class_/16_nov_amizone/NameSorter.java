import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NameSorter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        System.out.println("Enter names (type 'STOP' to end):");
        while (true) {
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("STOP")) break;
            names.add(name);
        }

        Collections.sort(names);

        System.out.println("Sorted names:");
        for (String name : names) {
            System.out.println(name);
        }
        sc.close();
    }
}

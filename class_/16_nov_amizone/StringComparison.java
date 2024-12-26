public class StringComparison {
    public static void main(String[] args) {
        // String literal
        String str1 = "Hello";
        String str2 = "Hello";

        // String created using new keyword
        String str3 = new String("Hello");

        // Comparison using ==
        System.out.println("Comparing using '==' operator:");
        System.out.println("str1 == str2: " + (str1 == str2)); // True, same memory reference
        System.out.println("str1 == str3: " + (str1 == str3)); // False, different memory reference

        // Comparison using equals method
        System.out.println("\nComparing using equals() method:");
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // True, same content
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // True, same content
    }
}

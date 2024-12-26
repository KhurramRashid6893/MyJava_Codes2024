class StringComparison {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");

        System.out.println("Using == operator:");
        System.out.println(s1 == s2); // true - same object reference
        System.out.println(s1 == s3); // false - different object references

        System.out.println("\nUsing equals() method:");
        System.out.println(s1.equals(s2)); // true - same content
        System.out.println(s1.equals(s3)); // true - same content
    }
}

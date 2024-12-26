import java.util.Scanner;

class Student {
    private int hallTicketNumber;
    private String studentName;
    private String department;

    // Constructor to initialize the student object
    public Student(int hallTicketNumber, String studentName, String department) {
        this.hallTicketNumber = hallTicketNumber;
        this.studentName = studentName;
        this.department = department;
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Hall Ticket Number: " + hallTicketNumber);
        System.out.println("Student Name: " + studentName);
        System.out.println("Department: " + department);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        Student[] students = new Student[n];

        // Input details for each student
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("Hall Ticket Number: ");
            int hallTicketNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            System.out.print("Student Name: ");
            String studentName = scanner.nextLine();
            System.out.print("Department: ");
            String department = scanner.nextLine();

            students[i] = new Student(hallTicketNumber, studentName, department);
        }

        // Display details of all students
        System.out.println("\nDetails of all students:");
        for (Student student : students) {
            student.displayStudentDetails();
        }

        scanner.close();
    }
}

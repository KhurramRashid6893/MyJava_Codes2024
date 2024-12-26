// Person class
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Employee subclass
class Employee extends Person {
    double salary;

    Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Salary: " + salary);
    }
}

// Manager subclass
class Manager extends Employee {
    String department;

    Manager(String name, int age, double salary, String department) {
        super(name, age, salary);
        this.department = department;
    }

    @Override
    void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Salary: " + salary + ", Department: " + department);
    }
}

public class Main4 {
    public static void main(String[] args) {
        Person person = new Person("John", 30);
        person.display();

        Employee employee = new Employee("Jane", 25, 50000);
        employee.display();

        Manager manager = new Manager("Alice", 35, 70000, "HR");
        manager.display();
    }
}

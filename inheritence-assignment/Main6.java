// Shape class
abstract class Shape {
    abstract double calculateArea();
}

// Rectangle subclass
class Rectangle extends Shape {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;  // Area of rectangle: length * width
    }
}

// Triangle subclass
class Triangle extends Shape {
    double base;
    double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;  // Area of triangle: 0.5 * base * height
    }
}

public class Main6 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 4);
        System.out.println("Rectangle Area: " + rectangle.calculateArea());

        Triangle triangle = new Triangle(4, 3);
        System.out.println("Triangle Area: " + triangle.calculateArea());
    }
}

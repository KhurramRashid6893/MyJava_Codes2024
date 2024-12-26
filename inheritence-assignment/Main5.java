// Shape class
class Shape {
    public double getPerimeter() {
        return 0;
    }

    public double getArea() {
        return 0;
    }
}

// Circle subclass overriding getPerimeter and getArea
class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;  // Perimeter of a circle: 2πr
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);  // Area of a circle: πr²
    }
}

public class Main5 {
    public static void main(String[] args) {
        Circle myCircle = new Circle(5);
        System.out.println("Perimeter: " + myCircle.getPerimeter());
        System.out.println("Area: " + myCircle.getArea());
    }
}

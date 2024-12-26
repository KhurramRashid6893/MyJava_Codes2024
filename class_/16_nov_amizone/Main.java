// Abstract class Shape
abstract class Shape {
    // Abstract method to be implemented by subclasses
    abstract void numberOfSides();
}

// Subclass Trapezoid
class Trapezoid extends Shape {
    @Override
    void numberOfSides() {
        System.out.println("A Trapezoid has 4 sides.");
    }
}

// Subclass Triangle
class Triangle extends Shape {
    @Override
    void numberOfSides() {
        System.out.println("A Triangle has 3 sides.");
    }
}

// Subclass Hexagon
class Hexagon extends Shape {
    @Override
    void numberOfSides() {
        System.out.println("A Hexagon has 6 sides.");
    }
}

// Main class to test the functionality
public class Main {
    public static void main(String[] args) {
        // Create objects of each subclass
        Shape trapezoid = new Trapezoid();
        Shape triangle = new Triangle();
        Shape hexagon = new Hexagon();

        // Display the number of sides for each shape
        trapezoid.numberOfSides();
        triangle.numberOfSides();
        hexagon.numberOfSides();
    }
}

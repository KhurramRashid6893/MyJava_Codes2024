interface Shape {
    double area();
    double perimeter();
}

class Rectangle implements Shape {
    private double length;
    private double width;

    // Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Implementing the area method
    @Override
    public double area() {
        return length * width;
    }

    // Implementing the perimeter method
    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

public class Main {
    public static void main(String[] args) {
        Shape myRectangle = new Rectangle(5.0, 3.0);
        
        System.out.println("Area: " + myRectangle.area());
        System.out.println("Perimeter: " + myRectangle.perimeter());
    }
}

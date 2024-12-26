abstract class Shape {
    public abstract void numberOfSides();
}

class Trapezoid extends Shape {
    @Override
    public void numberOfSides() {
        System.out.println("A Trapezoid has 4 sides.");
    }
}

class Triangle extends Shape {
    @Override
    public void numberOfSides() {
        System.out.println("A Triangle has 3 sides.");
    }
}

class Hexagon extends Shape {
    @Override
    public void numberOfSides() {
        System.out.println("A Hexagon has 6 sides.");
    }
}

class ShapeDemo {
    public static void main(String[] args) {
        Shape trapezoid = new Trapezoid();
        Shape triangle = new Triangle();
        Shape hexagon = new Hexagon();

        trapezoid.numberOfSides();
        triangle.numberOfSides();
        hexagon.numberOfSides();
    }
}

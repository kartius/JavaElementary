package lesson9;

public class Circle extends Figure {
    private final double number_pi = 3.14159265359;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double perimeter() {
        return 2*number_pi*radius;
    }

    @Override
    double area() {
        return number_pi*radius*radius;
    }
}

package lesson9;

public class Triangle extends Figure {
    private double side1, side2, side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    double perimeter() {
        return side1+side2+side3;
    }

    @Override
    double area() {
        double p = perimeter()/2;
        return Math.sqrt((double)p*(p - side1)*(p - side2)*(p - side3));
    }
}

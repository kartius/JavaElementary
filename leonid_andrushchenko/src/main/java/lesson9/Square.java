package lesson9;

public class Square extends Figure {
    private double side;

    public Square(double side) {
        this.side = side;
    }


    @Override
    double perimeter() {

        return side*4;
    }

    @Override
    double area() {
        return side*side;
    }
}

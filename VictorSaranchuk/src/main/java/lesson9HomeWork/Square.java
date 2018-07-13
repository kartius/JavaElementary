package lesson9HomeWork;

public class Square extends Figure {
    private double a;
    public Square(double side){
        this.a=side;
    }

    void area() {
        System.out.println("Area of square with side "+a+" is "+a*a);
    }

    void perimeter() {
        System.out.println("Perimeter of square with side "+a+" is "+a*4);
    }
}

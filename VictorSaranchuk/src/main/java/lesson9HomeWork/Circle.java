package lesson9HomeWork;

public class Circle extends Figure{
    private double r;

    public Circle(double r){
        this.r=r;
    }

    void area() {
        System.out.println("Area of circle with radius "+r+" is "+Math.PI*r*r);
    }

    void perimeter() {
        System.out.println("Perimeter of circle with radius "+r+" is "+2*Math.PI*r);
    }
}

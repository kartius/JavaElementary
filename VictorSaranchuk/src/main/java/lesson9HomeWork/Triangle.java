package lesson9HomeWork;

public class Triangle extends Figure {
    double a,b,c;

    public Triangle(double sideA, double sideB, double sideC){
        this.a=sideA;
        this.b=sideB;
        this.c=sideC;

    }

    void area() {
        double p=(a+b+c)/2;
        double area=(Math.sqrt((p*(p-a)*(p-b)*(p-c))));
        System.out.println("Area of triangle with sides "+a+","+b+","+c+" is "+area);
    }

    void perimeter() {
        System.out.println("Perimeter of triangle with sides "+a+","+b+","+c+" is "+(a+b+c));
    }
}

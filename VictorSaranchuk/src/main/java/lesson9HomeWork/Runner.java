package lesson9HomeWork;

public class Runner {
    public static void main(String[] args) {
        Square square=new Square(1);
        square.area();
        square.perimeter();
        System.out.println("--------------------");

        Circle circle=new Circle(1);
        circle.area();
        circle.perimeter();
        System.out.println("--------------------");

        Triangle triangle=new Triangle(10,10,10);
        triangle.area();
        triangle.perimeter();
        System.out.println("--------------------");

    }
}

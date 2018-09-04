package vadooss1_homework.figureAll_versions.figClass;

public class Runner {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 4, 5, 4);
        Square square = new Square(5);
        Circle circle = new Circle(10);

        System.out.println(triangle.getArea());
        System.out.println(triangle.getPerimeter());
        System.out.println(square.getArea());
        System.out.println(square.getPerimeter());
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());


    }
}

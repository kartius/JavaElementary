package lesson9;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Abstract class realization: ");// реализация при помощи абстрактного класса
        Square square = new Square(2);
        System.out.println(square.perimeter());
        System.out.println(square.area());
        System.out.println("--------------------");


        Triangle triangle = new Triangle(5, 5, 6);
        System.out.println(triangle.perimeter());
        System.out.println(triangle.area());
        System.out.println("--------------------");

        Circle circle = new Circle(5);
        System.out.println(circle.perimeter());
        System.out.println(circle.area());
        System.out.println("--------------------");

        System.out.println("\n" + "Anonimous classes realization: ");// реализация при помощи анонимных классов


        Figure square2 = new Figure() {
            private double side;

            public Figure setSide(double side){
                this.side = side;
                return this;
            }

            @Override
            double perimeter() {
                return side*4;
            }

            @Override
            double area() {
                return side*side;
            }
        }.setSide(2);

        System.out.println(square2.perimeter());
        System.out.println(square2.area());
        System.out.println("--------------------");


        Figure triangle2 = new Figure() {
            private double side1, side2, side3;

            public Figure setSide(double side1, double side2, double side3){
                this.side1 = side1;
                this.side2 = side2;
                this.side3 = side3;
                return this;
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
        }.setSide(5, 5, 6);

        System.out.println(triangle2.perimeter());
        System.out.println(triangle2.area());
        System.out.println("--------------------");


        Figure circle2 = new Figure() {
            private final double number_pi = 3.14159265359;
            private double radius;

            public Figure setSide(double radius){
                this.radius = radius;
                return this;
            }

            @Override
            double perimeter() {
                return 2*number_pi*radius;
            }

            @Override
            double area() {
                return number_pi*radius*radius;
            }
        }.setSide(5);

        System.out.println(circle2.perimeter());
        System.out.println(circle2.area());
    }
}

package vadooss1_homework.figureAll_versions.figClass;

public class Triangle extends FigClass {
    private int a, b, c, h;

    public Triangle(int a, int b, int c, int h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }

    @Override
    public int getArea() {
        return a*h/2;
    }

    @Override
    public int getPerimeter() {
        return a+b+c;
    }
}

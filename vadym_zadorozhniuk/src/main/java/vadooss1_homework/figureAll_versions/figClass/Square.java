package vadooss1_homework.figureAll_versions.figClass;

public class Square extends FigClass {
    private int a;

    public Square(int a) {
        this.a = a;
    }

    @Override
    public int getPerimeter() {
        return a*4;
    }

    @Override
    public int getArea() {
        return a*a;
    }
}

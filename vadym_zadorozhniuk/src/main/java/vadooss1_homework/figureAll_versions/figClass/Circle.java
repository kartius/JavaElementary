package vadooss1_homework.figureAll_versions.figClass;

public class Circle extends FigClass {
    private int r;

    public Circle(int r) {
        this.r = r;
    }

    @Override
    public int getArea() {
        return (int) (Math.PI*r*r);
    }

    @Override
    public int getPerimeter() {
        return (int)(2*Math.PI*r);
    }
}

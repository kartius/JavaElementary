package vadooss1_homework.figureAll_versions.figInterf;

public class Circle implements FigInterf {
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

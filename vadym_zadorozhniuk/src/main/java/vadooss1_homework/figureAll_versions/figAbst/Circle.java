package vadooss1_homework.figureAll_versions.figAbst;

public class Circle extends FigAbst {
    private int r;

    public Circle(int r) {
        this.r = r;
    }

    @Override
    protected int getArea() {
        return (int) (Math.PI*r*r);
    }

    @Override
    protected int getPerimeter() {
        return (int)(2*Math.PI*r);
    }
}

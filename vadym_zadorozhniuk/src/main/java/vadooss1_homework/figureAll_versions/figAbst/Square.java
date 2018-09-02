package vadooss1_homework.figureAll_versions.figAbst;

public class Square extends FigAbst {
    private int a;

    public Square(int a) {
        this.a = a;
    }

    @Override
    protected int getArea() {
        return a*a;
    }

    @Override
    protected int getPerimeter() {
        return a*4;
    }
}

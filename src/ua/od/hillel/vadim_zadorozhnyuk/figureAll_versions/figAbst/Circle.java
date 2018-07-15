package ua.od.hillel.vadim_zadorozhnyuk.figureAll_versions.figAbst;

public class Circle extends FigAbst {
    private int r;

    public Circle(int r) {
        this.r = r;
    }

    @Override
    int getArea() {
        return (int) (Math.PI*r*r);
    }

    @Override
    int getPerimeter() {
        return (int)(2*Math.PI*r);
    }
}

package ua.od.hillel.vadim_zadorozhnyuk.figureAll_versions.figAbst;

public class Square extends FigAbst {
    private int a;

    public Square(int a) {
        this.a = a;
    }

    @Override
    int getArea() {
        return a*a;
    }

    @Override
    int getPerimeter() {
        return a*4;
    }
}

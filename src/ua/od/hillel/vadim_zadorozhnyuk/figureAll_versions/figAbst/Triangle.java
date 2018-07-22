package ua.od.hillel.vadim_zadorozhnyuk.figureAll_versions.figAbst;

public class Triangle extends FigAbst {
    private int a, b, c, h;

    public Triangle(int a, int b, int c, int h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }

    @Override
    int getArea() {
        return a*h/2;
    }

    @Override
    int getPerimeter() {
        return a+b+c;
    }
}

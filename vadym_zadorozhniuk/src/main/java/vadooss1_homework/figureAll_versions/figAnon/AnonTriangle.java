package vadooss1_homework.figureAll_versions.figAnon;


import vadooss1_homework.figureAll_versions.figAbst.FigAbst;

public class AnonTriangle {
    private int a, b, c, h;

    public AnonTriangle(int a, int b, int c, int h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }


    FigAbst figAbst = new FigAbst() {
        @Override
        protected int getArea() {
            return a*h/2;
        }

        @Override
        protected int getPerimeter() {
            return a+b+c;
        }
    };


}

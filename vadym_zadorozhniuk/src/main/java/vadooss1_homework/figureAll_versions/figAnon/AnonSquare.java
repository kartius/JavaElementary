package vadooss1_homework.figureAll_versions.figAnon;

import vadooss1_homework.figureAll_versions.figAbst.FigAbst;

public class AnonSquare {
    private int a;

    public AnonSquare(int a) {
        this.a = a;
    }

    FigAbst figAbst = new FigAbst() {
        @Override
        protected int getArea() {
            return a*a;
        }

        @Override
        protected int getPerimeter() {
            return a*4;
        }
    };
}

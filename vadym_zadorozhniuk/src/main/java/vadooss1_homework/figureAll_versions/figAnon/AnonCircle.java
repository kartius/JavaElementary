package vadooss1_homework.figureAll_versions.figAnon;

import vadooss1_homework.figureAll_versions.figAbst.FigAbst;

public class AnonCircle {
    private int r;

    public AnonCircle(int r) {
        this.r = r;
    }

    FigAbst figAbst = new FigAbst() {


        @Override
        protected int getArea() {
            return (int) (Math.PI*r*r);
        }

        @Override
        protected int getPerimeter() {
            return (int)(2*Math.PI*r);
        }
    };


}

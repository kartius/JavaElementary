package vadooss1_homework.figureAll_versions.figInterf;

public class Square implements FigInterf {private int a;

    public Square(int a) {
        this.a = a;
    }


    @Override
    public int getArea() {
        return a*a;
    }

    @Override
    public int getPerimeter() {
        return a*4;
    }
}

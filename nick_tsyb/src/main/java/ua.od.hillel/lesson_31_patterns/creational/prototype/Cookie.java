package ua.od.hillel.lesson_31_patterns.creational.prototype;

public class Cookie implements Cloneable {

    protected int weight;

    @Override
    public Cookie clone() throws CloneNotSupportedException {
        Cookie copy = (Cookie) super.clone();
        return copy;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

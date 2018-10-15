package ua.od.hillel.lesson_31_patterns.structural.bridge;

public class BridgeRunner {

    public static void main(String[] args) {
        Shape tri = new Triangle(new RedColor());
        tri.applyColor();

        Shape pent = new Pentagon(new GreenColor());
        pent.applyColor();
    }
}

package ua.od.hillel.lesson_31_patterns.structural.adapter;

public class PenguinAdapter extends Penguin {

    private Seagull seagull = new Seagull();

    @Override
    public void move() {
        seagull.move();
    }
}

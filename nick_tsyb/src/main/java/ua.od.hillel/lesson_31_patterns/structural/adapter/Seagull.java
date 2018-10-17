package ua.od.hillel.lesson_31_patterns.structural.adapter;

public class Seagull implements Bird{
    @Override
    public void move() {
        System.out.println("fly");
    }
}

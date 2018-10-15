package ua.od.hillel.lesson_31_patterns.structural.adapter;

public class Runner {


    public static void main(String[] args) {
        Penguin penguin = new PenguinAdapter();
        penguin.move();

    }
}

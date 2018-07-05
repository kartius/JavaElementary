package ua.od.hillel.lesson_7.inheritance;

import ua.od.hillel.lesson_7.incapsulation.Auto;

public class Excavator extends Auto {


    private int currentSpeed;


    @Override
    public void run() {
        System.out.println("Excavator running...");
        currentSpeed = 20;
    }

    @Override
    public void stop() {
        System.out.println("Excavator stopping...");
        currentSpeed = 0;
    }


    @Override
    public int getCurrentSpeed() {
        return currentSpeed;
    }
}

package lesson_7.oop;

public class Excavator extends Auto {


    private int currentSpeed;

    @Override
    public void run() {
        System.out.println("Excavator run");
        currentSpeed = 15;
    }

    @Override
    public void stop() {
        System.out.println("Excavator stop");
        currentSpeed=0;
    }

    @Override
    public int getCurrentSpeed() {
        return currentSpeed;
    }
}

package ua.od.hillel.lesson_7.inheritance;

import ua.od.hillel.lesson_7.incapsulation.Auto;

public class Sedan extends Auto {


    @Override
    public void run() {
        super.run();
        System.out.println("Sedan");
    }

    @Override
    public void stop() {
        super.stop();
        System.out.println("Sedan");
    }

}

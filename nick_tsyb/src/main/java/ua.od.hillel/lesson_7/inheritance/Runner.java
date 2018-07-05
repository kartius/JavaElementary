package ua.od.hillel.lesson_7.inheritance;

public class Runner {


    public static void main(String[] args) {
        Sedan sedan = new Sedan();
        sedan.run();
        System.out.println(sedan.getCurrentSpeed());
        sedan.stop();
        System.out.println(sedan.getCurrentSpeed());
    }
}

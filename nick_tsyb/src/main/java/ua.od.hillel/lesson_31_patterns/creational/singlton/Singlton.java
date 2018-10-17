package ua.od.hillel.lesson_31_patterns.creational.singlton;

public class Singlton {

    private static Singlton instance;

    private Singlton() {
    }

//    public static Singlton getInstance() {
//        if (instance == null) {
//            instance = new Singlton();
//        }
//        return instance;
//    }

    public static synchronized Singlton getInstance() {
        if (instance == null) {
            instance = new Singlton();
        }
        return instance;
    }
}

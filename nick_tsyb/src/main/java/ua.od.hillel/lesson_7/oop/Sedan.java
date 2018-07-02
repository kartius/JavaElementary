package lesson_7.oop;

public class Sedan extends Auto{


    @Override
    public void run() {
        super.run();
        System.out.println("sedan");
    }

    @Override
    public void stop() {
        super.stop();
        System.out.println("sedan");
    }
}

package src.oleksandr_romanchenko.lesson7.OOP;

public class Sedan extends Auto {

    @Override           // Переопределение - один из случаев полиморфизма
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

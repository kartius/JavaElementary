package ua.od.hillel.lesson_28_threads.egg_checken_voice;

public class Runner {


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ChickenVoice());
        Thread t2 = new Thread(new EggVoice());


        System.out.println("starting...");


        t1.start();
        t2.start();

        t1.join();
        t2.join();



        System.out.println("Main thread working...");


    }
}

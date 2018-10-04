package ua.od.hillel.lesson_28_threads.egg_checken_voice;

import static java.lang.Thread.sleep;

public class ChickenVoice implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("chicken");
                sleep(5);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

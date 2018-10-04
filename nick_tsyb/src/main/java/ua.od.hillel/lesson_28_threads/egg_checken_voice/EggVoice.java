package ua.od.hillel.lesson_28_threads.egg_checken_voice;

import static java.lang.Thread.sleep;

public class EggVoice implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("egg");
                sleep(5);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

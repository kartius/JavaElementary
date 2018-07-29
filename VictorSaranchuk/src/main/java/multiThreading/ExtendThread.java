package multiThreading;

public class ExtendThread {
    public static void main(String[] args) {
        new NewThread();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("MainPotok: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("End");
        }
        System.out.println("MainPotok ended");
    }
}
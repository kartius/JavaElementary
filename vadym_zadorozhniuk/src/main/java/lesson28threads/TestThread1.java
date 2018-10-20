package lesson28threads;

public class TestThread1 implements Runnable {
    @Override
    public void run() {
        System.out.println("hello runnable!");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new TestThread1());
        t1.start();
    }
}

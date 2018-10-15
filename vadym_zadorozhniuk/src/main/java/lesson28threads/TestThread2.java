package lesson28threads;

public class TestThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("hello thread!");    }

    public static void main(String[] args) {
        TestThread2 t2 = new TestThread2();
        t2.start();
    }
}

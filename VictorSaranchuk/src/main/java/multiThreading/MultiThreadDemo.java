package multiThreading;

public class MultiThreadDemo {
    public static void main(String[] args) {
        new NewThread2("ONE ");
        new NewThread2("TWO ");
        new NewThread2("THREE ");

        try{
            Thread.sleep(10000);

        }catch (InterruptedException e){
            System.out.println("Current end");
        }
        System.out.println("Current ended");
    }
}

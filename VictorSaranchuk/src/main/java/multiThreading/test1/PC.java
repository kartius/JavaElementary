package multiThreading.test1;

public class PC {
    public static void main(String[] args) {
        Q q=new Q();
        new Producer(q);
        new Consumer(q);
        System.out.println("Press CTRL+C for STOP");
    }
}

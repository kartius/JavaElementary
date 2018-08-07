package solo.multiThreading;

public class ThreadTest {
    public static void main(String[] args) {
        Thread t=Thread.currentThread();
        System.out.println("Mane of thread: "+t);
        try{t.sleep(5000);}catch(InterruptedException e){
            System.out.println("Thread stop");}
        t.setPriority(4);
        t.setName("My Thread");
        System.out.println("Change Thread name: "+t);

        try {
            for (int n = 5; n > 0; n--) {
                System.out.println(n);
                t.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Thread stop");
        }

    }
}

package multiThreading.test1;

public class Consumer implements Runnable {
    Q q;
    Consumer(Q q){
        this.q=q;
        new Thread(this, "Catcher").start();

    }
    public void run(){
        while(true){
            q.get();

        }
    }
}

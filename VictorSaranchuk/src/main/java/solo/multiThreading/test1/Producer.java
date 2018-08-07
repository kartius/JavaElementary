package solo.multiThreading.test1;

public class Producer implements Runnable {
    Q q;
    Producer(Q q){
        this.q=q;
        new Thread(this, "Sender").start();

    }

    public void run(){
        int i=0;
        while(true){
            q.put(i++);
        }
    }
}

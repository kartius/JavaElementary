package solo.multiThreading;

public class ThreadTest2 implements Runnable {
    Thread t;

    ThreadTest2(){
        t=new Thread(this, "POTOK");
        System.out.println("DThread: "+t);
        t.start();
    }
    public  void run(){
        try{
            for (int i=5;i>0; i--){
                System.out.println("DThread: "+i);
                t.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println("GGG");
        }
        System.out.println("DThread Ended");
    }
}

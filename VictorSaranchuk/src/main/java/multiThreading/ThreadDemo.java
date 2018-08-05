package multiThreading;

public class ThreadDemo {
    public static void main(String[] args) {
        new ThreadTest2();

        try{
            for(int i=5;i>0;i--){
                System.out.println("CurrentThread: "+i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("End");}
        System.out.println("Current Ended");
        }

}

package multiThreading;

public class NewThread extends Thread {

    NewThread(){
    super("DemoThread");
        System.out.println("DochPotok: "+this);
        start();
    }
    public void run(){
        try{
            for(int i=5;i>0;i--){
                System.out.println("DochPotok: "+i);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println("End");
        }
        System.out.println("DochPotok ended");
    }
}

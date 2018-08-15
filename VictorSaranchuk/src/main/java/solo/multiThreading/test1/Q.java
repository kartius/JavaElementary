package solo.multiThreading.test1;

public class Q {
    int n;
    boolean valueSet=false;

    synchronized int get(){

        while (!valueSet)
        try{
            wait();
        }catch (InterruptedException e){
            System.out.println("CATCH E");
        }

        System.out.println("Catch "+n);
        valueSet=false;
        notify();
        return n;
    }
    synchronized void put(int n){

        while (valueSet)
        try {
            wait();
        } catch (InterruptedException e) {
            System.out.println("CATCH E");
        }


        this.n=n;
        valueSet=false;
        System.out.println("Send "+n);
        notify();
    }
}

package solo.multiThreading;

public class DemoJoin {
    public static void main(String[] args) {
        NewThread2 ob1=new NewThread2("ONE ");
        NewThread2 ob2=new NewThread2("TWO ");
        NewThread2 ob3=new NewThread2("THREE ");

        System.out.println("ONE MOVE "+ob1.t.isAlive());
        System.out.println("TWO MOVE "+ob2.t.isAlive());
        System.out.println("THREE MOVE "+ob3.t.isAlive());

        try{
            System.out.println("WAITING FOR END OF THREADS");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }catch (InterruptedException e){
            System.out.println("END");
        }

        System.out.println("ONE MOVE "+ob1.t.isAlive());
        System.out.println("TWO MOVE "+ob2.t.isAlive());
        System.out.println("THREE MOVE "+ob3.t.isAlive());
        System.out.println("CURRENT ENDED");

    }
}

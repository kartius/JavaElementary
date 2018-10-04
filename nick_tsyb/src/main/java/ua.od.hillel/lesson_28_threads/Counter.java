package ua.od.hillel.lesson_28_threads;

public class Counter {


    private int result;
    private int result1;


    Object obj1 = new Object();
    Object obj2 = new Object();


    public synchronized void inc() {
        result++;
    }

    public synchronized void dec() {
        result--;
    }


    public synchronized int getRes() {
        return result;

    }


    public void inc1(){
        synchronized (obj1){
            result++;
        }
    }

    public void inc2(){
        synchronized (obj2){
            result1++;
        }
    }
}

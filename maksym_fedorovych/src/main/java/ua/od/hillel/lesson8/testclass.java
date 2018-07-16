package ua.od.hillel.lesson8;

public class testclass {

    int i;

    public testclass (String ... str) {
        this();
        this.i = i;
    }


    public testclass (int i, int a) {
    this.i = i;
    }

    public testclass (){
        System.out.println("hello");
    }

    public void go(int speed){
        System.out.println(speed);
    }

    public int go(int speed, String msg){
        System.out.println(speed);
        return speed;
    }

    public class Inner{

    }
}

package solo.exceptions;

public class FinallyDemo {
    static void procA(){
        try{
            System.out.println("in body of procA()");
            throw new RuntimeException("demo");
        }finally {
            System.out.println("block of operator finally");
        }
    }
    static  void procB(){
        try{
            System.out.println("in body of method procB()");
            return;
        }finally {
            System.out.println("block of operator finally in method procB()");
        }
    }
    static void procC(){
        try{
            System.out.println("in body of method procC");
        }finally{
            System.out.println("block of operator finally in method procC()");
        }
    }

    public static void main(String[] args) {
        try{
            procA();
        }catch (Exception e){
            System.out.println("Exception intercept");
        }
        procB();
        procC();
    }
}

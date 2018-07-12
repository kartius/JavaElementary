package lesson8;

public class TestClass {

    int i, a;

    public TestClass(int i) {
        this.i = i;
    }
    public TestClass(){
        this(1);
        System.out.println("hello");
    }

    public TestClass(int i, int a) {
        this.i = i;
        this.a = a;
    }

    public TestClass(String ... str){
        this(1,4);
        System.out.println("hello");
    }


    public void go(int speed){
        System.out.println(
                speed
        );

    }
    public int go(int speed, String msg){
        System.out.println(speed);
        return speed;
    }

    public class Inner{
        private int b;

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }

    public static class Nested{
        static void test(){
            System.out.println("right");
        }
        
    }
}

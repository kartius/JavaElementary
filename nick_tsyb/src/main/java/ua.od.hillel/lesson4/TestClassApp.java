package ua.od.hillel.lesson4;

public class TestClassApp {


    static {
        System.out.println("static init");

    }


    {

        System.out.println("Hello TestClassApp");


    }


    private String str;


    public TestClassApp(String str) {
        this.str = str;
    }

    public TestClassApp() {


    }

    void testMethod() {

        System.out.println("Hello " + str);

    }

    static void testMethod1() {

        System.out.println("Hello static");
    }


}

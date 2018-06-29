package ua.od.hillel.maksym_fedorovych;

public class TestClassApp {

    static {
        System.out.println("StaticInitialization");//Выполняется при загрузке приложения
    }

    {
        System.out.println("HelloTestApp");
    }

    private  String str;

    public TestClassApp(String str) {
        this.str = str;

    }

    public TestClassApp() {
    }

    void testMethod(){
        System.out.println ("Hello" + str);
    }
    static void testMethod1 () {
        System.out.println("Static1");
    }
}

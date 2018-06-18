package ua.od.hillel.maksym_fedorovych;

public class RunnerApp {
    public static void main(String[] args) {
        TestClassApp aTestClassApp = new TestClassApp("sdsds");
        aTestClassApp.testMethod();
        aTestClassApp.testMethod1();

        TestClassApp bTestClassApp = new TestClassApp("sdsds3434");
        bTestClassApp.testMethod();
    }
}

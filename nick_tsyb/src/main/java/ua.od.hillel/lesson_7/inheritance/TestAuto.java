package ua.od.hillel.lesson_7.inheritance;

public class TestAuto extends Excavator {


    @Override
    public void run() {
        super.run();
    }

    public static void main(String[] args) {
        TestAuto testAuto = new TestAuto();
        testAuto.run();
    }
}

package lesson_7.oop;

public class Runner {


    public static void main(String[] args) {

//        Sedan sedan = new Sedan();
//        sedan.run();
//        System.out.println(sedan.getCurrentSpeed());
//        sedan.stop();
//        System.out.println(sedan.getCurrentSpeed());
//
//
//        Excavator excavator = new Excavator();
//        excavator.run();
//        System.out.println(excavator.getCurrentSpeed());
//        excavator.stop();
//        System.out.println(excavator.getCurrentSpeed());


        AutoInvoker autoInvoker = new AutoInvoker(new Auto());
        AutoInvoker autoInvoker1 = new AutoInvoker(new Sedan());
        AutoInvoker autoInvoker2 = new AutoInvoker(new Excavator());


    }
}

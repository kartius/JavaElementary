package ua.od.hillel.lesson_7.polymorphysm;

import ua.od.hillel.lesson_7.incapsulation.Auto;
import ua.od.hillel.lesson_7.inheritance.Excavator;
import ua.od.hillel.lesson_7.inheritance.Sedan;

public class Runner {


    public static void main(String[] args) {
        AutoInvoker autoInvoker = new AutoInvoker(new Auto());
        AutoInvoker autoInvoker1 = new AutoInvoker(new Sedan());
        AutoInvoker autoInvoker2 = new AutoInvoker(new Excavator());
    }
}

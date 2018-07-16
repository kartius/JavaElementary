package ua.od.hillel.lesson_7.polymorphysm;

import ua.od.hillel.lesson_7.incapsulation.Auto;

public class AutoInvoker {


    public AutoInvoker(Auto auto) {
        auto.run();
        System.out.println(auto.getCurrentSpeed());
        auto.stop();
        System.out.println(auto.getCurrentSpeed());
    }
}

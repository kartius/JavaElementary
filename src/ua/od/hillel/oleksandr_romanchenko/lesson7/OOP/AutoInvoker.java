package lesson7.OOP;

public class AutoInvoker {

    public AutoInvoker(Auto auto) {

        auto.run();
        System.out.println(auto.getCurrentSpeed());
        auto.stop();
        System.out.println(auto.getCurrentSpeed());
    }
}

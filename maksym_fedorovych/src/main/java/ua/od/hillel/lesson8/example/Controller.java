package ua.od.hillel.lesson8.example;

import java.security.PrivateKey;

public class Controller {

    private ServiceManager serviceManager = new ServiceManager();

    public void addVacuum(String str) {
        serviceManager.getDataService().add(str);
    }
}

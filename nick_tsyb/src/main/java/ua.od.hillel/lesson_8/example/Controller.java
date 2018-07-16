package lesson_8.example;

public class Controller {

    private ServiceManager serviceManager = new ServiceManager();



    public void addVacuum(String str){
        serviceManager.getDataService().add(str);
    }

}

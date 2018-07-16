package lesson8.example;

public class ServiceManager {

    private boolean isDataBaseExist;

    public DataService getDataService(){
        if (!isDataBaseExist){
            return  new MockDataService();

        }
        return null;
    }
}

package ua.od.hillel.lesson8.example;

public class ServiceManager {

    private boolean isDataBaseExists;


    public DataService getDataService(){
      if (!isDataBaseExists) {
          return new MockDataService();
      }
      return null;
    }

}

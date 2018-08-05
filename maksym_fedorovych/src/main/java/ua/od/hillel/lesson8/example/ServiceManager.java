package ua.od.hillel.lesson8.example;

public class ServiceManager {

    private boolean isDataBaseExists;


    public ua.od.hillel.lesson8.example.DataService getDataService(){
      if (!isDataBaseExists) {
          System.out.println("ppp1");
          return new ua.od.hillel.lesson8.example.MockDataService();

      }
      return null;
    }

}

package ua.od.hillel.lesson8.example;

public class MockDataService implements ua.od.hillel.lesson8.example.DataService {


    String [] vacuums= new String[10];

    @Override
    public void add(String str) {
        vacuums[0]=str;

    }

    @Override
    public void delete(String str) {

    }

    @Override
    public void sell(String str, int amount) {
        str = "23";
    }

    @Override
    public void getPrice(String str) {

    }
    @Override
    public int getAmount() {
        return 0;
    }
}

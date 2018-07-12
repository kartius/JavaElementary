package lesson8.example;

public class MockDataService implements DataService {

    String [] vacuums=new String[10];


    public void add(String str) {
    vacuums[0]=str;
    }

    public void delete(String str) {
    vacuums[0]=null;
    }

    public void sell(String str, int amount) {

    }

    public void getPrice(String str) {

    }

    public int getAmount() {
        return 0;
    }
}

package lesson_8.example;

public class MockDataService implements DataService{


    String [] vacuums=new String[10];

    @Override
    public void add(String str) {
        vacuums[0]=str;

    }

    @Override
    public void delete(String str) {
        vacuums[0]=null;
    }

    @Override
    public void sell(String str, int amount) {

    }

    @Override
    public void getPrice(String str) {

    }

    @Override
    public int getAmount() {
        return vacuums.length;
    }
}

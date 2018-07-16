package lesson8;

public class MockSubject implements Subject {
    private String name;

    public MockSubject(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }
}

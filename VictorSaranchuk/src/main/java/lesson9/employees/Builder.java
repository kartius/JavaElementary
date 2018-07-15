package lesson9.employees;

public class Builder extends Emloye {

    private Developer developer;

    public Builder(){
        System.out.println();;
        developer.work();
    }

    public void setDeveloper(Developer developer){
        this.developer=developer;
    }

    void work() {
        System.out.println("building...");
    }
}

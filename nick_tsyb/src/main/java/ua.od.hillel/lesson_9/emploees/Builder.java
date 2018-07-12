package lesson_9.emploees;

public class Builder extends Employe{

    private Developer developer;


    public Builder() {


        System.out.println();

        developer.work();


    }


    public void setDeveloper(Developer developer){
        this.developer=developer;
    }


    @Override
    void work() {
        System.out.println("building...");
    }
}

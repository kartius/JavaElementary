package main.java.ua.od.hillel.lesson8.L8homework;

public class Group extends MainGroup{
    private boolean isReal = false;

    @Override
    public boolean addStudent(Student std) {
        if  (super.addStudent(std)) {    //в предке добавляем студента
            isReal = (super.getRealAmount() >= 2);
            return true;
        } else return false;

    }

    @Override
    public void delStudent(Student std) {
        super.delStudent(std); //в предке удаляем студента
        isReal = (super.getRealAmount() >= 2);
    }

    public boolean getisReal()
    {
        return isReal;
    }


}

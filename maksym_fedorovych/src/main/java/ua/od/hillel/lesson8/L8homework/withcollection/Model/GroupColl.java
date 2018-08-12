package main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model;

public class GroupColl extends MainGroupColl {
    private boolean isReal = false;

    private SubjectOfStudyColl subjectOfStudyColl;


    @Override
    public boolean addStudent(StudentColl std) {
        if  (super.addStudent(std)) {    //в предке добавляем студента
            isReal = (super.getRealAmount() >= 2);
            return true;
        } else return false;

    }

    @Override
    public void delStudent(StudentColl std) {
        super.delStudent(std); //в предке удаляем студента
        isReal = (super.getRealAmount() >= 2);
    }

    public boolean getisReal()
    {
        return isReal;
    }

    public void setSubjectOfStudyColl(SubjectOfStudyColl subjectOfStudyColl) {
        this.subjectOfStudyColl = subjectOfStudyColl;
    }

    public SubjectOfStudyColl getSubjectOfStudyColl() {return this.subjectOfStudyColl;}
}

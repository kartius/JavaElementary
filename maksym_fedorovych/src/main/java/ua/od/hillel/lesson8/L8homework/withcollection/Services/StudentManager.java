package withcollection.Services;

import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.StudentColl;
import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.SubjectOfStudyColl;
import withcollection.Persisting.StudentCollRepository;

public class StudentManager {

    private StudentCollRepository studentCollRepository;


    public void add (StudentColl studentColl){studentCollRepository.add(studentColl);}
    public void del (StudentColl studentColl){studentCollRepository.del(studentColl);}
    public StudentColl getStudentColl(int index) {return studentCollRepository.getStudentColl(index);}
    public void addSubject(StudentColl studentColl, SubjectOfStudyColl subjectOfStudyColl) {studentCollRepository.addSubject(studentColl, subjectOfStudyColl);}
    public void delSubject(StudentColl studentColl, SubjectOfStudyColl subjectOfStudyColl) {studentCollRepository.delSubject(studentColl, subjectOfStudyColl);}
    public int getCount(){return studentCollRepository.getCount();}






    public void setStudentCollRepository(StudentCollRepository studentCollRepository)
    {
        this.studentCollRepository = studentCollRepository;
    }
}

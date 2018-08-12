package withcollection.Persisting;


import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.StudentClassColl;
import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.StudentColl;

public interface StudentClassCollRepository {

    void add (StudentClassColl studentClassColl);
    void del (StudentClassColl studentClassColl);
    void addStudentToClass (StudentClassColl stdClassColl, StudentColl std);
    void delStudentFromClass(StudentClassColl stdClassColl, StudentColl std);
    StudentClassColl getStudentClassColl(int index);
}

package withcollection.Persisting;

import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.StudentColl;
import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.SubjectOfStudyColl;

public interface StudentCollRepository {

    void add (StudentColl studentColl);
    void del (StudentColl studentColl);
    StudentColl getStudentColl(int index);
    void addSubject(StudentColl studentColl, SubjectOfStudyColl subjectOfStudyColl);
    void delSubject(StudentColl studentColl, SubjectOfStudyColl subjectOfStudyColl);
    SubjectOfStudyColl getSubjectOfStudyColl(int index);
    int getCount();

}

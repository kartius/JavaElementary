package withcollection.Persisting.impl;

import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.StudentColl;
import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.SubjectOfStudyColl;
import withcollection.Persisting.StudentCollRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentCollInMemory implements StudentCollRepository {
    private List<StudentColl> studentsColl = new ArrayList<>();
    @Override
    public void add(StudentColl studentColl) {
        studentsColl.add(studentColl);
    }

    @Override
    public void del(StudentColl studentColl) {
        for (int i = 0; i < studentsColl.size(); i++)
        {
            if (studentsColl.get(i).equals(studentColl))
            {
                studentsColl.remove(i);
            }
        }

    }

    @Override
    public StudentColl getStudentColl(int index) {
        return studentsColl.get(index);
    }

    @Override
    public void addSubject(StudentColl studentColl, SubjectOfStudyColl subjectOfStudyColl) {
        for (int i = 0; i < studentsColl.size(); i++)
        {
            if (studentsColl.get(i).equals(studentColl))
            {
                studentsColl.get(i).AddSubjectOfStudy(subjectOfStudyColl);
            }
        }
    }

    @Override
    public void delSubject(StudentColl studentColl, SubjectOfStudyColl subjectOfStudyColl) {
        for (int i = 0; i < studentsColl.size(); i++)
        {
            if (studentsColl.get(i).equals(studentColl))
            {
                studentsColl.get(i).DeleteSubjectOfStudy(subjectOfStudyColl);
            }
        }

    }

    @Override
    public SubjectOfStudyColl getSubjectOfStudyColl(int index) {

        return studentsColl.get(index).getSubjectOfStudy(0);
    }

    @Override
    public int getCount() {
        return studentsColl.size();
    }
}

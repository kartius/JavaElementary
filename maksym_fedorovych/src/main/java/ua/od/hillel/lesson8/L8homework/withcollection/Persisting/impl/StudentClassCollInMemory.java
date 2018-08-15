package withcollection.Persisting.impl;

import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.StudentClassColl;
import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.StudentColl;
import withcollection.Persisting.StudentClassCollRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentClassCollInMemory implements StudentClassCollRepository {
    private List<StudentClassColl> studentClassColls = new ArrayList<>();
    @Override
    public void add(StudentClassColl studentClassColl) {
        studentClassColls.add(studentClassColl);
    }

    @Override
    public void del(StudentClassColl studentClassColl) {
        for (int i = 0; i < studentClassColls.size(); i++)
        { if (studentClassColls.get(i).equals(studentClassColl))
         {
            studentClassColls.remove(i);
         }
        }
    }

    @Override
    public void addStudentToClass(StudentClassColl stdClassColl, StudentColl std) {
        for (int i = 0; i < studentClassColls.size(); i++)
        {
            if (studentClassColls.get(i).equals(stdClassColl))
            {
                studentClassColls.get(i).addStudent(std);
            }
        }
    }

    @Override
    public void delStudentFromClass(StudentClassColl stdClassColl, StudentColl std) {
        for (int i = 0; i < studentClassColls.size(); i++)
        {
            if (studentClassColls.get(i).equals(stdClassColl))
            {
                studentClassColls.get(i).delStudent(std);
            }
        }
    }

    @Override
    public StudentClassColl getStudentClassColl(int index) {
        return studentClassColls.get(index);
    }
}

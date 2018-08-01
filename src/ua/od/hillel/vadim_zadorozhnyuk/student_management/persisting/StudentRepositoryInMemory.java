package ua.od.hillel.vadim_zadorozhnyuk.student_management.persisting;

import com.google.gson.Gson;
import ua.od.hillel.vadim_zadorozhnyuk.student_management.Student;
import ua.od.hillel.vadim_zadorozhnyuk.student_management.Subject;

import java.util.ArrayList;
import java.util.LinkedList;

public class StudentRepositoryInMemory implements StudentRepository {



    LinkedList<Student> students = new LinkedList<>();

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public Student get(int id) {
        for(Student student:students){
            if(student.id == id){
                return student;
            }
        }
        return null;
    }

    @Override
    public void del(int id) {
        for(Student student:students){
            if(student.id == id){
                students.remove(student);
            }
        }

    }

    @Override
    public int getLevelClassOfStudent(Student student) throws Exception {
        return student.schoolClass.classLevel;
    }

    @Override
    public LinkedList<Subject> getAllSubjects(Student student) {
        return student.subjects;
    }
}

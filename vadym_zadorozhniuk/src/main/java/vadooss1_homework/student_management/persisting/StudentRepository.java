package vadooss1_homework.student_management.persisting;

import vadooss1_homework.student_management.Student;
import vadooss1_homework.student_management.Subject;

import java.util.LinkedList;

public interface StudentRepository {

    void add(Student student);

    Student get(int id);

    void del(int id);

//    void update(Student student);

    int getLevelClassOfStudent(Student student) throws Exception;

    LinkedList<Subject> getAllSubjects(Student student);



    }

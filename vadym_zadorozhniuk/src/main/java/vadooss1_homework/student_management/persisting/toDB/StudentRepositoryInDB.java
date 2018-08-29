package vadooss1_homework.student_management.persisting.toDB;

import vadooss1_homework.student_management.Student;
import vadooss1_homework.student_management.Subject;
import vadooss1_homework.student_management.persisting.StudentRepository;

import java.util.LinkedList;

public class StudentRepositoryInDB implements StudentRepository {
    @Override
    public void add(Student student) {

    }

    @Override
    public Student get(int id) {
        return null;
    }

    @Override
    public void del(int id) {

    }

    @Override
    public int getLevelClassOfStudent(Student student) throws Exception {
        return 0;
    }

    @Override
    public LinkedList<Subject> getAllSubjects(Student student) {
        return null;
    }
}

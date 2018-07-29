package ua.od.hillel.groupManager.persisting;

import ua.od.hillel.groupManager.model.Student;
import ua.od.hillel.groupManager.model.Subject;

import java.util.List;

public interface StudentRepository {

    int getLevelClassOfStudent(Student student) throws Exception;

    List<Subject> getAllSubjects(Student student);

    void add(Student student);

    void delete(int id);

    void update(Student student);

    Student get(int id);


}

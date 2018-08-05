package groupManager.persisting;
import groupManager.model.Group;
import groupManager.model.Student;
import groupManager.model.Subject;

import java.util.List;
public interface StudentRepository {
    int getLevelClassOfStudent(Student student)throws Exception;
    List<Subject> getAllSubjects(Student student);
    void add(Student student);
    void delete(int id);
    void update(Student student);
    Student get(int id);
}

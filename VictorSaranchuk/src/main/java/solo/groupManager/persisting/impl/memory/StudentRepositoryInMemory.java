package solo.groupManager.persisting.impl.memory;
import solo.groupManager.model.*;
import solo.groupManager.persisting.StudentRepository;

import java.util.ArrayList;
import java.util.List;
public class StudentRepositoryInMemory implements StudentRepository {

    List<Student> students=new ArrayList<Student>();

    public int getLevelClassOfStudent(Student student) throws Exception {
        for (Student currentStudent : students) {
            if (currentStudent.getId() == student.getId()) {
                return currentStudent.getSchoolClass().getLevel();
            } else {
                throw new Exception("Student doesn't exists");
            }
        }
        return 0;
    }

    public List<Subject> getAllSubjects(Student student) {
        List<Subject> allSubjects = new ArrayList<Subject>();
        allSubjects.addAll(student.getSchoolClass().getSubjects());
        for (Group group : student.getGroups()) {
            if (group.isAvailable()) {
                allSubjects.add(group.getSubject());
            }
        }
        return allSubjects;
    }

    public void add(Student student) {
    students.add(student);
    }

    public void delete(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
            }
        }
    }

    public void update(Student student) {
        for (Student currentStudent : students) {
            if (currentStudent.getId() == student.getId()) {
                currentStudent.setSchoolClass(student.getSchoolClass());
                currentStudent.setGroups(student.getGroups());
                currentStudent.setName(student.getName());
            }
        }
    }

    public Student get(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;

    }
}

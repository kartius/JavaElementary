package lesson8;

import java.util.ArrayList;

public interface SchoolClass {
    String getName();
    int getLevel();// Возвращает уровень, который имеет данный класс
    ArrayList<Student> getStudents();// Возвращает список студентов данного класса
    ArrayList<Subject> getSubjects();// Возвращает список предметов, которых проходят в данном классе
    void addStudent(Student student);
    void deleteStudent(String student_name);
    void addSubject(Subject subject);
    void deleteSubject(String subject_name);
}

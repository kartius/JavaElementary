package ua.od.hillel.groupManager.services;

import ua.od.hillel.groupManager.model.Group;
import ua.od.hillel.groupManager.model.Student;
import ua.od.hillel.groupManager.model.Subject;
import ua.od.hillel.groupManager.persisting.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private StudentRepository studentRepository;

    public void add(Student student) {
        studentRepository.add(student);
    }

    public Student getById(int id) {
        return studentRepository.get(id);
    }

    public void deleteById(int id){
        studentRepository.delete(id);
    }

    public int getLevelClassOfStudent(Student student) {
        try {
            return studentRepository.getLevelClassOfStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Subject> getAllSubjects(Student student) {
        return studentRepository.getAllSubjects(student);
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}

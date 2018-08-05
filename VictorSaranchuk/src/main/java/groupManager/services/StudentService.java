package groupManager.services;
import groupManager.model.Subject;
import groupManager.persisting.StudentRepository;
import groupManager.model.Student;

import java.util.List;

public class StudentService {

    private StudentRepository studentRepository;

    public void add(Student student){
        studentRepository.add(student);
    }

    public Student getById(int id){
        return studentRepository.get(id);
    }

    public void deleteById(int id){
        studentRepository.delete(id);
    }

    public int getClassOfStudent(Student student){
        try{
            return studentRepository.getLevelClassOfStudent(student);
        }catch (Exception e){
            e.printStackTrace();
        }return 0;
    }

    public List<Subject> getAllSubjects(Student student){
        return studentRepository.getAllSubjects(student);
    }

    public void setStudentRepository(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
}

package vadooss1_homework.student_management.services;


import vadooss1_homework.student_management.Student;
import vadooss1_homework.student_management.Subject;
import vadooss1_homework.student_management.persisting.StudentRepository;

import java.util.LinkedList;

public class StudentService {
    StudentRepository studentRepository;

    public void setStudentRepository(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public void add(Student student){studentRepository.add(student);}

    public Student get(int id){return studentRepository.get(id);}

    public void del(int id){studentRepository.del(id);}

    public int getLevelClassOfStudent(Student student) throws Exception{return studentRepository.getLevelClassOfStudent(student);}

   public LinkedList<Subject> getAllSubjects(Student student){return studentRepository.getAllSubjects(student);}


}

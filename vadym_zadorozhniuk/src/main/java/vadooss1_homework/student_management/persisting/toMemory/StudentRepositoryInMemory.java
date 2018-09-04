package vadooss1_homework.student_management.persisting.toMemory;


import vadooss1_homework.student_management.Student;
import vadooss1_homework.student_management.Subject;
import vadooss1_homework.student_management.persisting.StudentRepository;

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
        return student.schoolClassLevel;
    }

    @Override
    public LinkedList<Subject> getAllSubjects(Student student) {
        return student.subjects;
    }
}

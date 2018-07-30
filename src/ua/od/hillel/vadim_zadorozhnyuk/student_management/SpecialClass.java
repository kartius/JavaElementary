package ua.od.hillel.vadim_zadorozhnyuk.student_management;

import java.util.LinkedList;

public class SpecialClass extends SchoolClass {
    LinkedList<Student> students;

    Subject subject = new Subject("HTML", true);

    public void addStudent(Student student){
        students.addLast(student);
        StudentService studentService = new StudentService();
        studentService.addSubject(student, this.subject);
    }

    public void delStudent(Student student){
        students.remove(student);
        StudentService studentService = new StudentService();
        studentService.delSubject(student, this.subject);

    }
}

package vadooss1_homework.student_management;

import java.util.LinkedList;

public class SpecialClass extends SchoolClass {
    LinkedList<Student> students = new LinkedList<>();

    Subject subject = new Subject("HTML");

    public void addStudent(Student student){
        students.addLast(student);
        student.subjects.add(this.subject);
    }

    public void delStudent(Student student){
        students.remove(student);
        student.subjects.remove(this.subject);
    }
}

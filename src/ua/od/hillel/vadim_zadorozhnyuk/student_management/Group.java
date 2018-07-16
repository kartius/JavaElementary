package ua.od.hillel.vadim_zadorozhnyuk.student_management;

import java.util.LinkedList;

public class Group {
    protected Subject subject;
    protected LinkedList<Student> students = new LinkedList<>();
    protected boolean hasThreeStudents;

    public Group(Subject subject) {
        this.subject = subject;
    }

    public void addStudent(Student student){
        students.addLast(student);
        if(students.size()>=3){
            hasThreeStudents=true;
        }else{hasThreeStudents=false;}
    }

    public void delStudent(Student student){
        students.remove(student);
        if(students.size()>=3){
            hasThreeStudents=true;
        }else{hasThreeStudents=false;}
    }
}

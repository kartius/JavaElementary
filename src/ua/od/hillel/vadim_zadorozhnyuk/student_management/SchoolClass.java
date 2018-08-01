package ua.od.hillel.vadim_zadorozhnyuk.student_management;


import java.util.LinkedList;


public class SchoolClass {
    public int classLevel;
     LinkedList<Subject> subjects = new LinkedList<>();
     LinkedList<Student> students = new LinkedList<>();

    public SchoolClass(){}

    public SchoolClass(int classLevel){
        this.classLevel = classLevel;
    }

    public void setSubject(Subject subject){
        subjects.add(subject);
    }
    public void delSubject(Subject subject){
        subjects.remove(subject);
    }
    public void addStudent(Student student){
        students.add(student);
        student.schoolClass.classLevel=this.classLevel;
        student.subjects.addAll(this.subjects);
    }
    public void delStudent(Student student){
        students.remove(student);
        student.schoolClass.classLevel=0;
        student.subjects.removeAll(this.subjects);
    }


}

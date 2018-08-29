package vadooss1_homework.student_management;


import java.util.LinkedList;


public class SchoolClass {
    public int classLevel;
     LinkedList<Subject> subjects = new LinkedList<>();
     LinkedList<Student> students = new LinkedList<>();

    public SchoolClass(){
    }

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
        student.schoolClassLevel=this.classLevel;
        student.subjects.addAll(this.subjects);
        students.add(student);
    }
    public void delStudent(Student student){
        students.remove(student);
        student.schoolClassLevel=0;
        student.subjects.removeAll(this.subjects);
    }


}

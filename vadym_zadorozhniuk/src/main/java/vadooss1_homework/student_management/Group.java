package vadooss1_homework.student_management;

import java.util.LinkedList;

public class Group {
    public int id;
    public Subject subject = new Subject();
     LinkedList<Student> students = new LinkedList<>();
     public boolean hasThreeStudents;

     public Group(){}

    public Group(Subject subject, int id) {
        this.subject = subject;
        this.id = id;
    }

    public boolean isAvailable() {
        return hasThreeStudents;
    }

    public void addStudent(Student student) throws Exception {
        if(students.size()<=5){
        students.addLast(student);}else{throw new Exception("The group is full!");}
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

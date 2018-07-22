package ua.od.hillel.groupManager.model;

import java.util.List;

public class Group {

    private Subject subject;

    private List<Student> students;


    public boolean isAvailable() {
        if (students.size() >= 3) {
            return true;
        } else {
            return false;
        }
    }
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}

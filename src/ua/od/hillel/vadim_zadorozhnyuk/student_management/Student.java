package ua.od.hillel.vadim_zadorozhnyuk.student_management;

import java.util.LinkedList;

public class Student {
     public int id;
     String name;
    public SchoolClass schoolClass = new SchoolClass();
    public LinkedList<Group> groups = new LinkedList<>();
    public LinkedList<Subject> subjects = new LinkedList<>();


    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

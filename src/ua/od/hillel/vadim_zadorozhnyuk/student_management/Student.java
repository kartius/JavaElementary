package ua.od.hillel.vadim_zadorozhnyuk.student_management;

import java.util.LinkedList;

public class Student {
    protected String name;
    protected int classLevel;
    protected LinkedList<Subject> subjects = new LinkedList<>();

    public Student(String name, int classLevel) {
        this.name = name;
        this.classLevel = classLevel;
    }
}

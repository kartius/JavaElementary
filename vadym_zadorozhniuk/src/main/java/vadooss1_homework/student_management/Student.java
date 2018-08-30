package vadooss1_homework.student_management;

import java.util.LinkedList;

public class Student {
     public int id;
    public String name;
    public int schoolClassLevel;
    public LinkedList<Integer> groups = new LinkedList<>();
    public LinkedList<Subject> subjects = new LinkedList<>();


    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

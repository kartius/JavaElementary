package ua.od.hillel.groupManager.model;

import java.util.List;
import ua.od.hillel.groupManager.model.Subject;

public class SchoolClass {

    private int id;

    private int level;

    private List<Subject> subjects;

    public int getLevel() {
        return level;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

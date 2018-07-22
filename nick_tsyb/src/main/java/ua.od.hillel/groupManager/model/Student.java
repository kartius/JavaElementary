package ua.od.hillel.groupManager.model;

import java.util.List;

public class Student {

    private int id;

    private String name;

    private SchoolClass schoolClass;

    private List<Group> groups;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public List<Group> getGroups() {
        return groups;
    }

}

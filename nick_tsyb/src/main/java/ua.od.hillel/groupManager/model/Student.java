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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
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

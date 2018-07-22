package ua.od.hillel.groupManager.services;

import ua.od.hillel.groupManager.model.Group;
import ua.od.hillel.groupManager.model.Student;

public class GroupManager {

    private Group[] groups = new Group[10];

    public void add(Group group) {
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] == null) {
                groups[i] = group;
            }
        }
    }

    public int getAmountOfAvailableGroups() {
        int amount = 0;
        for (int i = 0; i < groups.length; i++) {
            if (groups[i].isAvailable()) {
                amount++;
            }
        }
        return amount;
    }

    public void assignStudentToGroup(Group group, Student student) {
        for (int i = 0; i < group.getStudents().size(); i++) {
            if (group.getStudents().get(i) == null) {
                group.getStudents().add(student);
            }
        }

        for (int i = 0; i < student.getGroups().size(); i++) {
            if (student.getGroups().get(i) == null) {
                student.getGroups().add(group);
            }
        }
    }

}

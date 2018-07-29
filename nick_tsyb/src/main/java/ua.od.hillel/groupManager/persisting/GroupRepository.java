package ua.od.hillel.groupManager.persisting;

import ua.od.hillel.groupManager.model.Group;
import ua.od.hillel.groupManager.model.Student;

public interface GroupRepository {

    void assignStudentToGroup(Group group, Student student);

    int getAmountOfAvailableGroups();

    void add(Group group);

    void delete(int id);

    void update(Group group);

    Group get(int id);
}

package ua.od.hillel.groupManager.persisting.impl.file;

import ua.od.hillel.groupManager.model.Group;
import ua.od.hillel.groupManager.model.Student;
import ua.od.hillel.groupManager.persisting.GroupRepository;

public class GroupRepositoryFile implements GroupRepository {
    @Override
    public void assignStudentToGroup(Group group, Student student) {

    }

    @Override
    public int getAmountOfAvailableGroups() {
        return 0;
    }

    @Override
    public void add(Group group) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Group group) {

    }

    @Override
    public Group get(int id) {
        return null;
    }
}

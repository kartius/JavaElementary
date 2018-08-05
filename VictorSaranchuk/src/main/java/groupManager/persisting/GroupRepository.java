package groupManager.persisting;
import groupManager.model.Group;
import groupManager.model.Student;

public interface GroupRepository {
    void assignStudentToGroup(Group group, Student student);
    int getAmountofAvailableGroups();
    void add(Group group);
    void delete(int id);
    void update(Group group);
    Group get(int id);

}

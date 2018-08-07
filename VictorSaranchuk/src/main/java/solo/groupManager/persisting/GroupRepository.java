package solo.groupManager.persisting;
import solo.groupManager.model.Group;
import solo.groupManager.model.Student;

public interface GroupRepository {
    void assignStudentToGroup(Group group, Student student);
    int getAmountofAvailableGroups();
    void add(Group group);
    void delete(int id);
    void update(Group group);
    Group get(int id);

}

package vadooss1_homework.student_management.persisting.toDB;

import vadooss1_homework.student_management.Group;
import vadooss1_homework.student_management.Student;
import vadooss1_homework.student_management.persisting.GroupRepository;

public class GroupRepositoryInDB implements GroupRepository {
    @Override
    public void add(Group group) {

    }

    @Override
    public Group get(int id) {
        return null;
    }

    @Override
    public void del(int id) {

    }

    @Override
    public int getAmountOfAvailableGroups() {
        return 0;
    }

    @Override
    public void assignStudentToGroup(Group group, Student student) throws Exception {

    }
}

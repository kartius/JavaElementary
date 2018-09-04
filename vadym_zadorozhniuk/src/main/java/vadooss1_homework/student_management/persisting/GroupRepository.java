package vadooss1_homework.student_management.persisting;


import vadooss1_homework.student_management.Group;
import vadooss1_homework.student_management.Student;

public interface GroupRepository {


    void add(Group group);

    Group get(int id);

    void del(int id);

//    void update(Group group);

    int getAmountOfAvailableGroups();

    void assignStudentToGroup(Group group, Student student) throws Exception;
}

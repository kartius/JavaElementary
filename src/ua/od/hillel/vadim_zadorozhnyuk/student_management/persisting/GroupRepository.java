package ua.od.hillel.vadim_zadorozhnyuk.student_management.persisting;


import ua.od.hillel.vadim_zadorozhnyuk.student_management.Group;
import ua.od.hillel.vadim_zadorozhnyuk.student_management.Student;

public interface GroupRepository {

    void add(Group group);

    Group get(int id);

    void del(int id);

//    void update(Group group);

    int getAmountOfAvailableGroups();

    void assignStudentToGroup(Group group, Student student) throws Exception;
}

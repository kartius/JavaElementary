package ua.od.hillel.groupManager.services;

import ua.od.hillel.groupManager.model.Group;
import ua.od.hillel.groupManager.model.Student;
import ua.od.hillel.groupManager.persisting.GroupRepository;
import ua.od.hillel.groupManager.persisting.StudentRepository;

public class GroupManager {

    private GroupRepository groupRepository;

    private StudentRepository studentRepository;

    public void add(Group group) {
        groupRepository.add(group);
    }

    public Group getById(int id){
       return groupRepository.get(id);
    }

    public int getAmountOfAvailableGroups() {
        return groupRepository.getAmountOfAvailableGroups();
    }

    public void assignStudentToGroup(Group group, Student student) {
        group.getStudents().add(student);
        groupRepository.update(group);
        student.getGroups().add(group);
        studentRepository.update(student);
    }

    public void setGroupRepository(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}

package groupManager.services;
import groupManager.model.Group;
import groupManager.model.Student;
import groupManager.persisting.GroupRepository;
import groupManager.persisting.StudentRepository;


public class GroupManager {
private GroupRepository groupRepository;
private StudentRepository studentRepository;

public void add(Group group){
    groupRepository.add(group);
}

public void deleteById(int id){
    groupRepository.delete(id);
}

public Group getById(int id){
    return groupRepository.get(id);
}

public int getAmountOfAvailableGrous(){
    return groupRepository.getAmountofAvailableGroups();
}

public void assignStudentToGroup(Group group, Student student){
    group.getStudents().add(student);
    groupRepository.update(group);
    student.getGroups().add(group);
    studentRepository.update(student);
}

public  void setGroupRepository(GroupRepository groupRepository){
    this.groupRepository=groupRepository;
}

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}

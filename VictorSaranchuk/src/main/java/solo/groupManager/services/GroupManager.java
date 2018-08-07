package solo.groupManager.services;
import solo.groupManager.model.Group;
import solo.groupManager.model.Student;
import solo.groupManager.persisting.GroupRepository;
import solo.groupManager.persisting.StudentRepository;


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
    if(group.getStudents().size()>5){
        group.getStudents().remove(student);
        groupRepository.update(group);
        student.getGroups().remove(group);
        studentRepository.update(student);
        System.out.println(student.getName()+" can't add to group");
    }
}

public  void setGroupRepository(GroupRepository groupRepository){
    this.groupRepository=groupRepository;
}

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}

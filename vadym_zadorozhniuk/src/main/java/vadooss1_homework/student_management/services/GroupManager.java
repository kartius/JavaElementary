package vadooss1_homework.student_management.services;


import vadooss1_homework.student_management.Group;
import vadooss1_homework.student_management.Student;
import vadooss1_homework.student_management.persisting.GroupRepository;

public class GroupManager {
    GroupRepository groupRepository;

   public void setGroupRepository(GroupRepository groupRepository){this.groupRepository=groupRepository;}

    public void add(Group group){groupRepository.add(group);}

    public Group get(int id){return groupRepository.get(id);}

    public void del(int id){groupRepository.del(id);}

    public int getAmountOfAvailableGroups(){return groupRepository.getAmountOfAvailableGroups();
    }

    public void assignStudentToGroup(Group group, Student student) throws Exception{groupRepository.assignStudentToGroup(group,student);}



}

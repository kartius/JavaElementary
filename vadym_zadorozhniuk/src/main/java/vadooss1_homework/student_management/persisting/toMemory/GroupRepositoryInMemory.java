package vadooss1_homework.student_management.persisting.toMemory;


import vadooss1_homework.student_management.Group;
import vadooss1_homework.student_management.Student;
import vadooss1_homework.student_management.persisting.GroupRepository;

import java.util.LinkedList;

public class GroupRepositoryInMemory implements GroupRepository {

    LinkedList<Group> groups = new LinkedList<>();

    @Override
    public void add(Group group) {
        groups.add(group);

    }

    @Override
    public Group get(int id) {
        for(Group group:groups){
            if(group.id == id){
                return group;
            }
        }
        return null;
    }

    @Override
    public void del(int id) {
        for(Group group:groups){
            if(group.id == id){
                groups.remove(group);
            }
        }

    }

    @Override
    public int getAmountOfAvailableGroups() {
        int count = 0;
        for (Group group : groups) {
            if(group.isAvailable()){
                count++;
            }

        }
        return count;
    }

    @Override
    public void assignStudentToGroup(Group group, Student student) throws Exception {
        if(groups.contains(group)){
        int point = groups.indexOf(group);
        group.addStudent(student);
        student.groups.add(group.id);
        student.subjects.add(group.subject);
        groups.set(point, group);}else{
            group.addStudent(student);
            student.groups.add(group.id);
            student.subjects.add(group.subject);
            groups.add(group);
        }
    }
}

package groupManager.persisting.impl;
import groupManager.model.Group;
import groupManager.model.Student;
import groupManager.persisting.GroupRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupRepositoryInMemory implements GroupRepository {

    private List<Group>groups = new ArrayList<Group>();

    public void assignStudentToGroup(Group group, Student student) {

    }

    public int getAmountofAvailableGroups() {
        int i=0;
        for (Group group:groups
             ) {if(group.isAvailable()){
                 i++;
        }
        }
        return i;
    }

    public void add(Group group) {
    groups.add(group);
    }

    public void delete(int id) {
    Iterator<Group> iterator=groups.iterator();
    while((iterator.hasNext())){
        if(iterator.next().getId()==id){
            iterator.remove();
        }
    }
    }

    public void update(Group group) {
        for (Group currentGroup: groups
             ) {if(group.getId()==currentGroup.getId()){
                 currentGroup.setStudents(group.getStudents());
                 currentGroup.setSubject(group.getSubject());
        }
            
        }
    }

    public Group get(int id) {
        for (Group group:groups
             ) {if(group.getId()==id){return group;}

        }
        return null;
    }
}

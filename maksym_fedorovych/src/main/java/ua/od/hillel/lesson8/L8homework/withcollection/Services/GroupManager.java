package withcollection.Services;

import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.GroupColl;
import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.StudentColl;
import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.SubjectOfStudyColl;
import withcollection.Persisting.GroupCollRepository;
//import withcollection.Persisting.StudentCollRepository;

public class GroupManager {

    private GroupCollRepository groupCollRepository;
    //private StudentCollRepository studentCollRepository;

    public void add(GroupColl groupColl) {groupCollRepository.add(groupColl);}
    public void del(GroupColl groupColl) {groupCollRepository.del(groupColl);}
    public void getGroupColl(int index) {groupCollRepository.getGroupColl(index);}
    public void addSrudent(StudentColl studentColl, GroupColl groupColl) {groupCollRepository.addStudent(studentColl, groupColl);}
    public void delStudent(StudentColl studentColl, GroupColl groupColl) {groupCollRepository.delStudent(studentColl, groupColl);}
    public int getValid(int mode) {return groupCollRepository.getValidGroups(mode);}
    public boolean isValid(int index) {return groupCollRepository.isValidGroup(index);}
    public void setSubjectOfStudyColl(int index,SubjectOfStudyColl subjectOfStudyColl) {groupCollRepository.setSubjectOfStudyColl(index, subjectOfStudyColl);}
    public SubjectOfStudyColl getSubjectOfStudyColl(int index) {return groupCollRepository.getSubjectOfStudyColl(index);}
    public GroupColl findGroupOnSubject(SubjectOfStudyColl subjectOfStudyColl){return groupCollRepository.findGroupOnSubject(subjectOfStudyColl);}
    public int getGroupsCount() {return groupCollRepository.getGroupsCount();}
    public void setGroupCollRepository(GroupCollRepository groupCollRepository)
    {
        this.groupCollRepository = groupCollRepository;
    }
}

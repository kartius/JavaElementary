package withcollection.Persisting;

import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.GroupColl;
import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.StudentColl;
import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.SubjectOfStudyColl;

public interface GroupCollRepository {

    void add (GroupColl groupColl);
    void del (GroupColl groupColl);
    GroupColl getGroupColl (int index);
    void addStudent (StudentColl studentColl, GroupColl groupColl);
    void delStudent (StudentColl studentColl, GroupColl groupColl);
    int getValidGroups(int mode);
    boolean isValidGroup(int index);
    void setSubjectOfStudyColl(int index,SubjectOfStudyColl subjectOfStudyColl);
    SubjectOfStudyColl getSubjectOfStudyColl(int index);
    GroupColl findGroupOnSubject(SubjectOfStudyColl subjectOfStudyColl);
    int getGroupsCount();



}

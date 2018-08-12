package withcollection.Persisting.impl;

import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.GroupColl;
import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.StudentColl;
import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.SubjectOfStudyColl;
import withcollection.Persisting.GroupCollRepository;

import java.util.ArrayList;
import java.util.List;

public class GroupCollRepositoryInMemory implements GroupCollRepository {

    private List<GroupColl> groups = new ArrayList<>();
    @Override
    public void add(GroupColl groupColl) {
      groups.add(groupColl);
    }

    @Override
    public void del(GroupColl groupColl) {
       for (int i = 0; i < groups.size(); i++)
       { if (groups.get(i).equals(groupColl))
           {
               groups.remove(i);
           }
       }
    }

    @Override
    public GroupColl getGroupColl(int index) {
        return groups.get(index);
    }

    @Override
    public void addStudent(StudentColl studentColl, GroupColl groupColl) {
       for (int i = 0; i < groups.size(); i++)
       {
           if (groups.get(i).equals(groupColl))
           {
               groups.get(i).addStudent(studentColl);
           }
       }
    }

    @Override
    public void delStudent(StudentColl studentColl, GroupColl groupColl) {
                for (int i = 0; i < groups.size(); i++)
        {
            if (groups.get(i).equals(groupColl))
            {
                groups.get(i).delStudent(studentColl);
            }
        }
    }

    @Override
    public int getValidGroups(int mode) {
        int counter = 0;
        for (int i = 0; i < groups.size(); i++)
        {
            if (groups.get(i).getisReal())
            {
                counter++;
                if (mode == 1)
                {
                    System.out.println("Group " + groups.get(i).getUnicid());
                }
            }
        }
        System.out.println("Valid Groups " +  counter + "Total Groups " + groups.size());
        return counter;

    }

    @Override
    public boolean isValidGroup(int index) {
        return groups.get(index).getisReal();
    }

    @Override
    public void setSubjectOfStudyColl(int index, SubjectOfStudyColl subjectOfStudyColl) {
        groups.get(index).setSubjectOfStudyColl(subjectOfStudyColl);
     }

    @Override
    public SubjectOfStudyColl getSubjectOfStudyColl(int index) {
        return groups.get(index).getSubjectOfStudyColl();
    }

    @Override
    public GroupColl findGroupOnSubject(SubjectOfStudyColl subjectOfStudyColl) {
        boolean flag = false;
        GroupColl groupColl = null;
        for (int i = 0; i < groups.size(); i++)
        {
            if  (subjectOfStudyColl.equals(groups.get(i).getSubjectOfStudyColl()))
            {groupColl = groups.get(i); flag = true;}
        }
        if (flag) {return groupColl;} else {return null;}


    }

    @Override
    public int getGroupsCount() {
        return groups.size();
    }
}

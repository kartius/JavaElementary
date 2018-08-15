package withcollection.Persisting.impl;

import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.SubjectOfStudyColl;
import withcollection.Persisting.SubjectOfStudyCollRepository;

import java.util.ArrayList;
import java.util.List;

public class SubjectOfStudyCollInMemory implements SubjectOfStudyCollRepository {
    private List<SubjectOfStudyColl> subjectOfStudyColls = new ArrayList<>();
    @Override
    public void add(SubjectOfStudyColl subjectOfStudyColl) {
        subjectOfStudyColls.add(subjectOfStudyColl);
    }

    @Override
    public void del(SubjectOfStudyColl subjectOfStudyColl) {
        for (int i = 0; i < subjectOfStudyColls.size(); i++)
        {
            if (subjectOfStudyColls.get(i).equals(subjectOfStudyColl))
            {
                subjectOfStudyColls.remove(i);
            }
        }
    }

    @Override
    public SubjectOfStudyColl getSubjectOfStudyColl(int index) {
        return subjectOfStudyColls.get(index);
    }

    @Override
    public int getCount() {
        return subjectOfStudyColls.size();
    }
}

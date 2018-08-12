package withcollection.Persisting;

import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.SubjectOfStudyColl;

public interface SubjectOfStudyCollRepository {

    void add (SubjectOfStudyColl subjectOfStudyColl);
    void del (SubjectOfStudyColl subjectOfStudyColl);
    SubjectOfStudyColl getSubjectOfStudyColl(int index);
    int getCount();

}

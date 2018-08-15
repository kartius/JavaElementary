package withcollection.Services;

import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.SubjectOfStudyColl;
import withcollection.Persisting.SubjectOfStudyCollRepository;

public class SubjectOfStudyManager {

   private SubjectOfStudyCollRepository subjectOfStudyCollRepository;




    public void add (SubjectOfStudyColl subjectOfStudyColl) {subjectOfStudyCollRepository.add(subjectOfStudyColl);}
    public void del (SubjectOfStudyColl subjectOfStudyColl) {subjectOfStudyCollRepository.del(subjectOfStudyColl);}
    public SubjectOfStudyColl getSubjectOfStudyColl(int index) {return subjectOfStudyCollRepository.getSubjectOfStudyColl(index);}
    public int getCount() {return subjectOfStudyCollRepository.getCount();}

    public void setSubjectOfStudyCollRepository (SubjectOfStudyCollRepository subjectOfStudyCollRepository)
    {
        this.subjectOfStudyCollRepository = subjectOfStudyCollRepository;
    }
}

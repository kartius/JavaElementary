package main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model;

import java.util.ArrayList;
import java.util.List;

public class StudentColl {

   public String SName; /*Name*/
   public int unicid;
   //public int CountSubject = 0;
   //public SubjectOfStudyColl[] subjectOfStudy;
   private List<SubjectOfStudyColl> subjectOfStudyColls = new ArrayList<>(); /*Пока более одного не добавляем*/



   //public StudentColl() {  subjectOfStudy = new SubjectOfStudyColl[1]; }

   public boolean AddSubjectOfStudy(SubjectOfStudyColl subj){

       //Проверяем был такой предмет или нет
       boolean flag = true;
       for (int i = 0; i < subjectOfStudyColls.size(); i++)
       {
           if (subjectOfStudyColls.get(i).equals(subj)) {flag = false;}
       }
       if (flag) {subjectOfStudyColls.add(subj);}
       return flag;
   }

    public void DeleteSubjectOfStudy(SubjectOfStudyColl subj){

        for (int i = 0; i < subjectOfStudyColls.size(); i++)
        {
            if (subjectOfStudyColls.get(i).equals(subj)) {subjectOfStudyColls.remove(i);}
        }
    }

    public int getCountSubject() {
        return subjectOfStudyColls.size();
    }

    public SubjectOfStudyColl getSubjectOfStudy(int index)
    { return subjectOfStudyColls.get(index);
    }
}

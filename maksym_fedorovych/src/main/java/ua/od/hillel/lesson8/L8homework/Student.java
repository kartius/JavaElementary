package main.java.ua.od.hillel.lesson8.L8homework;

public class Student {

   public String SName; /*Name*/
   public int unicid;
   public int CountSubject = 0;
   public SubjectOfStudy[] subjectOfStudy;


   public Student() {
        subjectOfStudy = new SubjectOfStudy[1];
    }

   public boolean AddSubjectOfStudy(SubjectOfStudy subj){

       //Проверяем был такой предмет или нет
       boolean flag = true;
       for (int i = 0; i < subjectOfStudy.length; i++)
       {
           if ((subjectOfStudy[i] != null)&&(subjectOfStudy[i].UnicId == subj.UnicId))
           {
               flag = false;
           }

       }

       if (flag) {
           SubjectOfStudy[] subjectOfStudyLocal = new SubjectOfStudy[CountSubject + 1]; //Создаем локальный массив
           for (int i = 0; i < CountSubject; i++) //Заполняем значениями из уже закрепленных предметов
           {
               subjectOfStudyLocal[i] = subjectOfStudy[i];
           }
           subjectOfStudyLocal[CountSubject] = subj;//Добавляем новый
           subjectOfStudy = new SubjectOfStudy[CountSubject + 1];//Пересоздаем массив объекта с предметами
           CountSubject++; //Сдвигаем счетчик предметов
           for (int i = 0; i < CountSubject; i++) //Заполняем массив объекта из локального массива
           {
               subjectOfStudy[i] = subjectOfStudyLocal[i];
           }
       }
       return flag;

       /*КРИВО НО КОЛЛЕКЦИИ МЫ ПОКА НЕ УЧИЛИ*/
   }

    public void DeleteSubjectOfStudy(SubjectOfStudy subj){
       if (CountSubject!=0) {
           SubjectOfStudy[] subjectOfStudyLocal = new SubjectOfStudy[CountSubject - 1]; //Создаем локальный массив
           for (int i = 0; i < CountSubject; i++) //Заполняем значениями из уже закрепленных предметов минус искомій предмет
           {
               if (subj.UnicId !=  subjectOfStudy[i].UnicId) { subjectOfStudyLocal[i] = subjectOfStudy[i];}
           }
           CountSubject--;//Сдвигаем счетчик предметов
           subjectOfStudy = new SubjectOfStudy[CountSubject];//Пересоздаем массив объекта с предметами
           for (int i = 0; i < CountSubject; i++) //Заполняем массив объекта из локального массива
           {subjectOfStudy[i] = subjectOfStudyLocal[i];}
       }
    }
}

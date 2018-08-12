package withcollection;

import main.java.ua.od.hillel.lesson8.L8homework.withcollection.Model.*;
import withcollection.Persisting.GroupCollRepository;
import withcollection.Persisting.StudentClassCollRepository;
import withcollection.Persisting.StudentCollRepository;
import withcollection.Persisting.SubjectOfStudyCollRepository;
import withcollection.Persisting.impl.GroupCollRepositoryInMemory;
import withcollection.Persisting.impl.StudentClassCollInMemory;
import withcollection.Persisting.impl.StudentCollInMemory;
import withcollection.Persisting.impl.SubjectOfStudyCollInMemory;
import withcollection.Services.GroupManager;
import withcollection.Services.StudentClassManager;
import withcollection.Services.StudentManager;
import withcollection.Services.SubjectOfStudyManager;

public class Runner {
    private static int random(int minValue, int maxValue)
    {
        double drandom; //случайное значение не спроецированное на интервал
        //int minValue = -1000; //Нижний предел
        //int maxValue = 1; //Верхний предел
        int toZero = 0; //смещение к 0
        int res; //результат

        toZero = minValue*-1;
        drandom = Math.random();


        int percentValue;
        if ((int)(drandom*1000) >100 ||(int)(drandom*1000) < 100 )
        { percentValue = (int)(drandom*100); }
        else
        { percentValue = (int)(drandom*1000); }



        res = (int)((Math.round(((maxValue + toZero)*percentValue/100.00))) - toZero);


        //System.out.println("Случайное значение не спроецированное на интервал: " + drandom);
        //System.out.println("Случайный процент: " + percentValue);
        //System.out.println("Случайное значение: " + res);
        return res;

    }
    public static void main(String[] args) {

        /*Инициализируем репозитории*/
        GroupCollRepository groupCollRepository = new GroupCollRepositoryInMemory();
        GroupManager groupManager = new GroupManager();
        groupManager.setGroupCollRepository(groupCollRepository);

        StudentCollRepository studentCollRepository = new StudentCollInMemory();
        StudentManager studentManager = new StudentManager();
        studentManager.setStudentCollRepository(studentCollRepository);

        StudentClassCollRepository studentClassCollRepository = new StudentClassCollInMemory();
        StudentClassManager studentClassManager = new StudentClassManager();
        studentClassManager.setStudentClassCollRepository(studentClassCollRepository);

        SubjectOfStudyCollRepository subjectOfStudyCollRepository = new SubjectOfStudyCollInMemory();
        SubjectOfStudyManager subjectOfStudyManager = new SubjectOfStudyManager();
        subjectOfStudyManager.setSubjectOfStudyCollRepository(subjectOfStudyCollRepository);

        /*Create 16 student and two classes with 8 student per each*/
        StudentColl studentColl;
        for (int i = 0; i < 16; i++)
        {
            studentColl = new StudentColl();
            studentColl.unicid = i;
            studentManager.add(studentColl);
        }
        StudentClassColl studentClassColl;
        for (int i = 0; i < 2; i++ )
        {
            studentClassColl = new StudentClassColl();
            studentClassColl.setUnicid(i);
            studentClassColl.ClassLevel = 1;
            studentClassManager.add(studentClassColl);
            if (i == 0) {
                for (int j = 0; j < 8; j++) {
                    studentClassManager.addStudentToClass(studentClassColl, studentManager.getStudentColl(j));

                }
            }
            else
            {
                for (int j = 8; j < 16; j++) {
                    studentClassManager.addStudentToClass(studentClassColl, studentManager.getStudentColl(j));

                }
            }



        }

        /*Create 5 subject of study*/
        for (int i = 0; i < 5; i++)
        {
            SubjectOfStudyColl subjectOfStudyColl = new SubjectOfStudyColl();
            subjectOfStudyColl.UnicId = i;
            subjectOfStudyManager.add(subjectOfStudyColl);
        }

        /* Раскидываем случайным образом по одному доп редмету на студента*/
        for (int i = 0; i < studentManager.getCount() ; i++)
        {
            studentManager.getStudentColl(i).AddSubjectOfStudy( subjectOfStudyManager.getSubjectOfStudyColl(random(0,4)));
        }

        /*Создаем группы и раскидіваем на них студентов*/
        boolean flag = false;
        for (int i = 0; i < studentManager.getCount() ; i++)
        {

            if ((groupManager.getGroupsCount() > 0) && (groupManager.findGroupOnSubject(studentManager.getStudentColl(i).getSubjectOfStudy(0)) != null))
            {
                groupManager.findGroupOnSubject(studentManager.getStudentColl(i).getSubjectOfStudy(0)).addStudent(studentManager.getStudentColl(i));
            } else
                {
                GroupColl groupColl = new GroupColl();
                groupColl.setUnicid(i);
                groupColl.setSubjectOfStudyColl(studentManager.getStudentColl(i).getSubjectOfStudy(0));
                groupColl.addStudent(studentManager.getStudentColl(i));
                groupManager.add(groupColl);
            }
        }

        groupManager.getValid(1);



    }
}

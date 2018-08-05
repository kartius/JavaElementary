package main.java.ua.od.hillel.lesson8.L8homework;

public class SchoolMain {


    //Массивы
    private Student[] students;
    private Group[] groups;
    private StudentClass[] studentClassFL;/*Firwst Level*/
  //  private StudentClass[] studentClassSL;/*Second Level*/
   // private StudentClass[] studentClassTL;/*Therd Level*/
    private SubjectOfStudy[] subjectOfStudy;


    public int maxStudentsinClass = 30;

    /*Дополнитенье предметы будут назначены студентам случайно исходя из назначенной группы
      Группы будут содержать по 3 необязательных предмета.
      Группы так же будут назначены случайно, по две группы на студента
    */
    //public void StartSchool(int AmtStudents, int AmtSubOfStd, int AmtMaxStdInClass, int ){

        //}

    private void CreateGroups() {/*Распределяет студентов по группам с предметами. Рекомендуется вызывать
                                              только в случае заполненных студентов и дополнительных предметов.*/
        int flag = 0;
        Group[] group1;
        groups = null;
        if (students.length != 0) {
            for (int i = 0; i < students.length; i++) {
              if ((  groups == null/* i == 0*/) && (students[i].subjectOfStudy.length > 0))
                {//первая группа  - первый студент
                    groups = new Group[1];
                    groups[0] = new Group();
                    groups[0].addStudent(students[i]);
                } else
                {//группы уже есть и необходимо искать соотвествие
                   flag = 0;
                   for (int j = 0; j < groups.length; j++)
                   {
                    //   System.out.println("group[j].student.length " + groups[j].student.length);
                     //  System.out.println("group[j].student[0].unicid " + groups[j].student[0].unicid );
                      // System.out.println("group[j].student[0].subjectOfStudy[0].unicid " + groups[j].student[0].subjectOfStudy[0].UnicId);
                       //System.out.println("students[i].subjectOfStudy[0].unicid " + students[i].subjectOfStudy[0].UnicId);
                       if      //((group[j].student.length > 0) &&
                               ((groups[j].student.length > 0) && (groups[j].student[0].subjectOfStudy.equals(students[i].subjectOfStudy)))
                       {
                         groups[j].addStudent(students[i]);
                         flag = 1;
                       }

                   }
                    if (flag == 0) { //небыло ни одного совпадения и надо добавлять группу
                    group1 = new Group[groups.length];
                    for (int n = 0; n < groups.length; n++){group1[n] = groups[n];}
                    groups = new Group[group1.length+1];
                    for (int k = 0; k < groups.length-1; k++){groups[k] = group1[k];}
                    groups[groups.length-1] = new Group();
                    groups[groups.length-1].addStudent(students[i]);
                   }

                }


            }
        }
    }

    private int random (int minValue, int maxValue)
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

    public void SetSchool(int aCountStudent, int aCountSubOfStd){

        SchoolImpl schoolImpl = new SchoolImpl();

        students = new Student[aCountStudent];
        schoolImpl.CreateStudents(students);
        subjectOfStudy = new SubjectOfStudy[aCountSubOfStd];
        schoolImpl.CreateSubtectOfStudy(subjectOfStudy);

        //Вычисляем ко-во классов и создаем их
        studentClassFL = new StudentClass[(int)Math.ceil(aCountStudent/maxStudentsinClass)];
        schoolImpl.CreateStudentClass(studentClassFL, 1, 30);

        //Распределение студентов по классам
        int n = 0;
        int j = 0;
        for (int i = 0; i < studentClassFL.length; i++)
        {
          for (j = n; j < students.length; j++)
          {
              if (!studentClassFL[i].addStudent(students[j]))
              {
                  n = j;
                  break;
              }

          }
        }

        //назначаем по три случайных предмета. В случае совпадения предметов предмет назначем не будет.
        // Итог мы получим по каждому студенту как минимум по одному дополнительному предмету


       for (int i = 0; i < students.length; i++ )
       {
           for (j = 0; j < 3; j++)
           {
             students[i].AddSubjectOfStudy(subjectOfStudy[random(0, aCountSubOfStd-1)]);
           }
       }

       CreateGroups();

    }

}
